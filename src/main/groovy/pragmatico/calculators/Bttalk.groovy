package pragmatico.calculators

import groovy.transform.CompileStatic

@CompileStatic
class Bttalk implements RatingProvider {
  BttalkEntity[] entities

  Double getRating() {
    if (!entities) {
      return 0
    }
    def uniqDates = entities*.postDate*.clearTime().unique()
    def rating = entities.size() * coefficient
    def val = uniqDates.size() ? rating / uniqDates.size() : 0 as Double
    [val, ratingCeil].min() as Double
  }
}
