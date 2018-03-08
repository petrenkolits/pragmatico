package pragmatico.calculatators

import groovy.transform.CompileStatic

@CompileStatic
class Calc {
  static RatingProvider from(TwEntity[] entities) {
    new Twittr(entities: entities)
  }

  static RatingProvider from(FbEntity[] entities) {
    new Facebook(entities: entities)
  }

  static  RatingProvider from(BttalkEntity[] entities) {
    new Bttalk(entities: entities)
  }
}
