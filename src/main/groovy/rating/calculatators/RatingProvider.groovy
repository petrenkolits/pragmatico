package rating.calculatators

import groovy.transform.CompileStatic

@CompileStatic
interface RatingProvider {
  static Float coefficient = 0.001f

  Float getRating()
}
