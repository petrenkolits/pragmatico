package pragmatico.commands.project

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import pragmatico.Project

@GrailsCompileStatic
class Show implements Validateable {
  String id
  Project result

  static constraints = {
    result bindable: false, nullable: true
  }

  Show call() {
    setResult Project.findById(id)
    this
  }
}
