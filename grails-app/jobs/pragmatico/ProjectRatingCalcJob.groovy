package pragmatico

import grails.gorm.transactions.Transactional
import grails.plugins.quartz.QuartzJob
import groovy.transform.CompileDynamic
import org.quartz.JobExecutionContext
import pragmatico.social.scrapers.Bttalk
import pragmatico.social.scrapers.Facebook
import pragmatico.social.scrapers.Twittr
import pragmatico.calculators.Calc
import pragmatico.calculators.ProjectEntity

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
    log.info("Processing project: ${item.id}")
    Date startDate = (new Date() - 3).clearTime()
    Project project = Project.findById item.id
    if (project) {
      Calc.withProject(project) {
        twRating Calc.from(twittr.getData(item.twitterlink, startDate)).rating
        fbRating Calc.from(facebook.getData(item.fblink, startDate)).rating
        btRating Calc.from(bttalk.getData(item.bitcoinlink, startDate)).rating
      }
      project.with {
        dynamicRatingUpdatedAt = new Date()
        save()
      }
      log.info("Project: ${item.id} new rating: ${project.rating}, change: ${project.ratingChange}")
    } else {
      log.error("Failed to fetch project: ${item.id}")
    }
  }
}
