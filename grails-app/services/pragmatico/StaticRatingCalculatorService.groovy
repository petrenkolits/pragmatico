package pragmatico

import grails.compiler.GrailsCompileStatic
import pragmatico.fields.project.ProjectProperties

@GrailsCompileStatic
class StaticRatingCalculatorService {
  static final WeightMap = [
    sitelink: 0.2,
    whitepaper: 0.2,
    offer: 0.2,
    tokensize: 0.1,
    currencies: { curr -> curr},
    youtube: 0.1
  ]

  Float perform(ProjectProperties obj) {
    WeightMap.inject(0.0) { res, String k, v ->
      if (obj.getProperty(k)) {
        if (v instanceof Closure) {
          res += v(obj.getProperty(k))
        } else {
          res += v
        }
      }
    }
  }
}
