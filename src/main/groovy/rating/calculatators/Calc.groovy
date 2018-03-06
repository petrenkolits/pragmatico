package rating.calculatators

import groovy.transform.CompileStatic
import pragmatico.social.scrapers.FbEntity
import pragmatico.social.scrapers.TwEntity

@CompileStatic
class Calc {
  static RatingProvider from(TwEntity[] entities) {
    new Twittr(entities: entities)
  }

  static RatingProvider from(FbEntity[] entities) {
    new Facebook(entities: entities)
  }
}
