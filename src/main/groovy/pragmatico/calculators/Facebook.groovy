package pragmatico.calculators

import groovy.transform.CompileStatic

@CompileStatic
class Facebook implements RatingProvider {
  FbEntity[] entities

  Double getRating() {
    if (!entities) {
      return 0
    }
    def uniqDates = entities*.createdAt*.clearTime().unique()
    def rating = entities.sum { FbEntity e -> (e.reactions + e.shares) * coefficient } as Double
    def val = uniqDates.size() ? rating / uniqDates.size() : 0 as Double
    [val, ratingCeil].min() as Double
  }
}
