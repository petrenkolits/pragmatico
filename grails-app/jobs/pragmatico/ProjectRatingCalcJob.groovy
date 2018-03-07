package pragmatico

import grails.gorm.transactions.Transactional
import grails.plugins.quartz.QuartzJob
import groovy.transform.CompileDynamic
import org.quartz.JobExecutionContext
import pragmatico.social.scrapers.Facebook
import pragmatico.social.scrapers.Twittr
import pragmatico.calculatators.Calc
import pragmatico.calculatators.ProjectEntity

@CompileDynamic
class ProjectRatingCalcJob implements QuartzJob {
  Facebook facebook
  Twittr twittr

  def execute(JobExecutionContext context) {
    processProject context.mergedJobDataMap.get('projectEntity') as ProjectEntity
  }

  @Transactional
  def processProject(ProjectEntity item) {
    Date startDate = (new Date() - 3).clearTime()
    Project project = Project.findById item.id
    if (project) {
      Float rating = 0.0f
      rating += Calc.from(facebook.getData(item.fblink, startDate)).rating
      rating += Calc.from(twittr.getData(item.twitterlink, startDate)).rating
      project.currentDynamicRating = rating
      project.rating = project.initialRating + rating as Float
      project.dynamicRatingUpdatedAt = new Date()
      project.save()
    }
  }
}
