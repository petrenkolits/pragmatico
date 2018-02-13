package pragmatico.commands.project

import grails.compiler.GrailsCompileStatic
import pragmatico.Project
import pragmatico.commands.Interactionable
import pragmatico.project.Status

@GrailsCompileStatic
class Index extends Interactionable {
  String type

  static constraints = {
    importFrom Interactionable
    type blank: true, nullable: true
  }

  Index call() {
    setResult Project.findAllByStatus(Status.APPROVED, [max: 4])
    this
  }
}
