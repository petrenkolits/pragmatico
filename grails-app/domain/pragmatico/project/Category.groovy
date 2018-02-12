package pragmatico.project

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Category {
  String title
  Boolean isChecked

  static constraints = {
  }
}
