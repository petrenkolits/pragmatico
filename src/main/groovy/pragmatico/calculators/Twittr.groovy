package pragmatico.calculators

import groovy.transform.CompileStatic

@CompileStatic
class Twittr implements RatingProvider {
  TwEntity[] entities

  Float getRating() {
    Float val = entities.sum { TwEntity e -> (e.favoriteCount + e.retweetCount) * coefficient } as Float
    [val, ratingCeil].min()
  }
}
