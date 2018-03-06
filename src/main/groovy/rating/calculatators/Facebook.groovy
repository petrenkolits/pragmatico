package rating.calculatators

import groovy.transform.CompileStatic
import pragmatico.social.scrapers.FbEntity

@CompileStatic
class Facebook implements RatingProvider {
  FbEntity[] entities

  Float getRating() {
    [entities.sum { FbEntity e -> (e.reactions + e.shares) * coefficient } as Float, 0.5].min() as Float
  }
}
