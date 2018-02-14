package pragmatico.fields.project.embedds

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Period {
  String name
  String duration
  Integer sale

  static constraints = {
  }
}
