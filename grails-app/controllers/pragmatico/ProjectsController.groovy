package pragmatico

import grails.compiler.GrailsCompileStatic
import pragmatico.project.Status

@GrailsCompileStatic
class ProjectsController implements AuthenticatedController, ExceptionHandler {
  def index() {
    [projects: Project.findAllByStatus(Status.APPROVED)]
  }

  def save(Project project) {
    project.account = currentUser
    project.status = Status.PENDING
    project.validate() ? project.save() : renderErrors(project.errors)
  }

  def show() {
    [project: Project.findById(params.id)]
  }
}
