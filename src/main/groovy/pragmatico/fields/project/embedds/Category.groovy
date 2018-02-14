package pragmatico.fields.project.embedds

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Category {
  String title
  Boolean isChecked

  static constraints = {
  }
}
