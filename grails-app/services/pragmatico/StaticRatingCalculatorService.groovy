package pragmatico

import pragmatico.fields.project.ProjectProperties
import pragmatico.fields.project.embedds.Advisor
import pragmatico.fields.project.embedds.Founder

class StaticRatingCalculatorService {
  final WeightMap = [
    sitelink: 0.2,
    whitepaper: 0.2,
    offer: 0.2,
    tokensize: 0.1,
    currencies: { String curr -> curr.split(/\W/).count { it } },
    youtube: 0.1,
    founders: { List<Founder> list ->
      (list.fblink + list.twitterlink + list.linkedinlink).findAll { it }.size() * 0.1
    },
    advisors: { List<Advisor> list ->
      (list.fblink + list.twitterlink + list.linkedinlink).findAll { it }.size() * 0.1
    }
  ]

  Float perform(ProjectProperties props) {
    WeightMap.inject(0f) { Float res, String k, v ->
      if (props.getProperty(k)) {
        res += (v instanceof Closure) ? v(props.getProperty(k)) : v
      }
      res
    }
  }
}
