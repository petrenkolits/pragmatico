package rating.calculatators

import groovy.transform.CompileStatic

@CompileStatic
class Facebook implements RatingProvider {
  FbEntity[] entities

  Float getRating() {
    Float val = entities.sum { FbEntity e -> (e.reactions + e.shares) * coefficient } as Float
    [val, ratingCeil].min()
  }
}
