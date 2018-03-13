package pragmatico.calculators

import groovy.transform.CompileStatic

@CompileStatic
class Twittr implements RatingProvider {
  TwEntity[] entities

  Double getRating() {
    if (!entities) {
      return 0
    }
    def uniqDates = entities*.createdAt*.clearTime().unique()
    def rating = entities.sum { TwEntity e -> (e.favoriteCount + e.retweetCount) * coefficient } as Double
    def val = uniqDates.size() ? rating / uniqDates.size() : 0 as Double
    [val, ratingCeil].min() as Double
  }
}
