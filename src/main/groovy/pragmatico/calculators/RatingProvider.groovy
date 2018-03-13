package pragmatico.calculators

import groovy.transform.CompileStatic

@CompileStatic
interface RatingProvider {
  static Double coefficient = 0.001f
  static Double ratingCeil = 0.5f

  Double getRating()
}
