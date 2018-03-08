package pragmatico

import grails.gorm.transactions.Transactional
import grails.plugins.quartz.QuartzJob
import groovy.transform.CompileDynamic
import org.quartz.JobExecutionContext
import pragmatico.social.scrapers.Bttalk
import pragmatico.social.scrapers.Facebook
import pragmatico.social.scrapers.Twittr
import pragmatico.calculatators.Calc
import pragmatico.calculatators.ProjectEntity

@CompileDynamic
class ProjectRatingCalcJob implements QuartzJob {
  Facebook facebook
  Twittr twittr
  Bttalk bttalk

  def execute(JobExecutionContext context) {
    processProject context.mergedJobDataMap.get('projectEntity') as ProjectEntity
  }

  @Transactional
  def processProject(ProjectEntity item) {
    Date startDate = (new Date() - 3).clearTime()
    Project project = Project.findById item.id
    project?.with {
      currentDynamicRating =
        Calc.from(facebook.getData(item.fblink, startDate)).rating +
        Calc.from(twittr.getData(item.twitterlink, startDate)).rating +
        Calc.from(bttalk.getData(item.bitcoinlink, startDate)).rating as Float
      rating = initialRating + currentDynamicRating as Float
      dynamicRatingUpdatedAt = new Date()
      save()
    }
  }
}
