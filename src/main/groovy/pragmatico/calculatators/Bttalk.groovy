package pragmatico.calculatators

import groovy.transform.CompileStatic

@CompileStatic
class Bttalk implements RatingProvider {
  BttalkEntity[] entities

  Float getRating() {
//    Float val = entities.sum { BttalkEntity e -> (e.reactions + e.shares) * coefficient } as Float
//    [val, ratingCeil].min()
    0.0f
  }
}
