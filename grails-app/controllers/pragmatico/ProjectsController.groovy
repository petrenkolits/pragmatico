package pragmatico

import grails.compiler.GrailsCompileStatic
import pragmatico.commands.project.Index
import pragmatico.project.Status

@GrailsCompileStatic
class ProjectsController implements AuthenticatedController, ExceptionHandler {
  def index(Index cmd) {
    [projects: cmd().result]
  }

  def save(Project project) {
    project.account = currentUser
//    project.status = Status.PENDING
    project.status = Status.APPROVED
    project.validate() ? project.save() : renderErrors(project.errors)
  }

  def show() {
    [project: Project.findById(params.id)]
  }
}
