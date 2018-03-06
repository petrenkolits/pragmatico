package pragmatico

import pragmatico.social.scrapers.Facebook
import pragmatico.social.scrapers.Twittr
import rating.calculatators.Calc

class ProjectRatingCalcJob {
  Facebook facebook
  Twittr twittr

  def execute(context) {
    def startDate = (new Date() - 3).clearTime()
//    context.mergedJobDataMap.each { e ->
//
//    }
//    println facebook.getData('popularjournal', startDate)
    println Calc.from(facebook.getData('popularjournal', startDate)).rating +
      Calc.from(twittr.getData('neo4j', startDate)).rating
//    println context.mergedJobDataMap
  }
}
