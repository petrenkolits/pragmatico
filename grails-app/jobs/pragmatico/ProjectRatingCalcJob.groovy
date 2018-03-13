package pragmatico

import grails.gorm.transactions.Transactional
import grails.plugins.quartz.QuartzJob
import groovy.transform.CompileDynamic
import org.quartz.JobExecutionContext
import pragmatico.social.scrapers.Bttalk
import pragmatico.social.scrapers.Facebook
import pragmatico.social.scrapers.Twittr
import pragmatico.calculators.Calc

@CompileDynamic
class ProjectRatingCalcJob implements QuartzJob {
  Facebook facebook
  Twittr twittr
  Bttalk bttalk

  def execute(JobExecutionContext context) {
    def id = context.mergedJobDataMap.get('id') as String
    processProject id, (new Date() - 3).clearTime()
  }

  @Transactional
  def processProject(String id, Date startDate) {
    log.info("Processing project: ${id}")
    Project project = Project.findById id
    if (project) {
      Calc.withProject(project) {
//        addRating Calc.from(twittr.getData(item.project, startDate)).rating
//        addRating Calc.from(facebook.getData(project.fblink, startDate)).rating
        addRating Calc.from(bttalk.getData(project.bitcoinlink, startDate)).rating
      }
      project.with {
        ratingUpdatedAt = new Date()
        save()
      }
      log.info("Project: ${id} new rating: ${project.rating}, change: ${project.ratingChange}")
    } else {
      log.error("Failed to fetch project: ${id}")
    }
  }
}
