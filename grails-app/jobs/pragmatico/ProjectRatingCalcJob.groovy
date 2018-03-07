package pragmatico

import grails.plugins.quartz.QuartzJob
import groovy.transform.CompileDynamic
import org.quartz.JobExecutionContext
import pragmatico.social.scrapers.Facebook
import pragmatico.social.scrapers.Twittr
import rating.calculatators.Calc
import rating.calculatators.ProjectEntity

@CompileDynamic
class ProjectRatingCalcJob implements QuartzJob {
  Facebook facebook
  Twittr twittr

  def execute(JobExecutionContext context) {
    context.mergedJobDataMap.each { e ->
      processProject e as ProjectEntity
    }
  }

  def processProject(ProjectEntity item) {
    Date startDate = (new Date() - 3).clearTime()
    Float rating = 0.0f
    rating += Calc.from(facebook.getData(item.fblink, startDate)).rating
    rating += Calc.from(twittr.getData(item.twitterlink, startDate)).rating
    Project project = Project.find item._id
    if (project) {
      project.currentDynamicRating = rating
      project.rating = project.initialRating + rating
      project.dynamicRatingUpdatedAt = new Date()
      project.save()
    }
  }
}
