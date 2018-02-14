package pragmatico

import pragmatico.fields.project.ProjectProperties

class StaticRatingCalculatorService {
  final WeightMap = [
    sitelink: 0.2,
    whitepaper: 0.2,
    offer: 0.2,
    tokensize: 0.1,
    currencies: { String curr -> curr.split(/\W/).count { it } },
    youtube: 0.1
  ]

  Float perform(ProjectProperties props) {
    WeightMap.collect { k, v ->
      if (props.getProperty(k)) {
        (v instanceof Closure) ? v(props.getProperty(k)) : v
      }
    }.findAll { it != null }.sum() as Float
  }
}
