package pragmatico.commands.project

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import pragmatico.Project

import pragmatico.fields.project.embedds.Status

@GrailsCompileStatic
class Index implements Validateable {
  String type
  String sort = 'rating'
  String order = 'desc'
  Integer limit = 6
  List<Project> result

  static constraints = {
    type blank: true, nullable: true
    result bindable: false, nullable: true
  }

  Index call() {
    setResult Project.findAllByStatus(Status.APPROVED, [max: limit, sort: sort, order: order])
    this
  }
}
