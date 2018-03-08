package pragmatico

import grails.plugins.quartz.QuartzJob
import groovy.transform.CompileDynamic
import org.bson.conversions.Bson
import org.quartz.JobExecutionContext
import pragmatico.calculatators.ProjectEntity

import static com.mongodb.client.model.Projections.fields
import static com.mongodb.client.model.Projections.include
import static com.mongodb.client.model.Filters.or
import static com.mongodb.client.model.Filters.and
import static com.mongodb.client.model.Filters.ne
import static com.mongodb.client.model.Filters.lt

@CompileDynamic
class RatingInitiatorJob implements QuartzJob {
  static triggers = {
//    simple repeatInterval: 10000l // execute job once in 5 seconds
    cron cronExpression: '0 0/30 * * * ?'
  }

  static final pickFields = ['fblink', 'twitterlink', 'bitcoinlink']
  static final Bson dfltSelector = or(pickFields.collect { ne it, null })
  static final Bson projection = fields(include('id', *pickFields))

  def execute(JobExecutionContext context) {
    Date startDate = (new Date() - 1).clearTime()
    Bson selector = and(dfltSelector, lt('dynamicRatingUpdatedAt', startDate))
    Project.collection.find(selector).projection(projection).toList().each { e ->
      ProjectRatingCalcJob.triggerNow(projectEntity: new ProjectEntity(e.asImmutable()))
    }
  }
}
