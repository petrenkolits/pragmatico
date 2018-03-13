package pragmatico

import grails.plugins.quartz.QuartzJob
import groovy.transform.CompileDynamic
import org.bson.conversions.Bson
import org.quartz.JobExecutionContext

import static com.mongodb.client.model.Projections.fields
import static com.mongodb.client.model.Projections.include
import static com.mongodb.client.model.Filters.or
import static com.mongodb.client.model.Filters.and
import static com.mongodb.client.model.Filters.ne
import static com.mongodb.client.model.Filters.eq
import static com.mongodb.client.model.Filters.lt

@CompileDynamic
class RatingInitiatorJob implements QuartzJob {
  static triggers = {
//    simple repeatInterval: 10000l // execute job once in 5 seconds
//    cron cronExpression: '0 0/30 * * * ?'
    simple startDelay: 10000, repeatCount: 1
  }

  static final pickFields = ['fblink', 'twitterlink', 'bitcoinlink']
  static final Bson dfltSelector = or(pickFields.collect { ne it, null })
  static final Bson projection = fields(include('id'))

  def execute(JobExecutionContext context) {
    Date startDate = (new Date() - 1).clearTime()
    Bson dateSelector = or([lt('ratingUpdatedAt', startDate),
      eq('ratingUpdatedAt', null)])
    Bson selector = and(dfltSelector, dateSelector)
    Project.collection.find(selector).projection(projection).toList().each { e ->
      ProjectRatingCalcJob.triggerNow(id: e._id)
    }
  }
}
