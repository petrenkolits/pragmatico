package pragmatico.calculators

import groovy.transform.CompileStatic

@CompileStatic
class Bttalk implements RatingProvider {
  BttalkEntity[] entities

  Float getRating() {
    Double val = entities.size() * coefficient
    [val, ratingCeil].min()
  }
}
