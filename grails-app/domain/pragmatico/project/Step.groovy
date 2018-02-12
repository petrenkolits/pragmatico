package pragmatico.project

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Step {
  String title
  Boolean isDone

  static constraints = {
  }
}
