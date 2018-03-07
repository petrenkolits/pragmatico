package rating.calculatators

import groovy.transform.CompileStatic

@CompileStatic
interface RatingProvider {
  static Float coefficient = 0.001f
  static Float ratingCeil = 0.5f

  Float getRating()
}
