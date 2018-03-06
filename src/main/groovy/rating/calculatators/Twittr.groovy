package rating.calculatators

import groovy.transform.CompileStatic
import pragmatico.social.scrapers.TwEntity

@CompileStatic
class Twittr implements RatingProvider {
  TwEntity[] entities

  Float getRating() {
    [entities.sum { TwEntity e -> (e.favoriteCount + e.retweetCount) * coefficient }, 0.5].min() as Float
  }
}
