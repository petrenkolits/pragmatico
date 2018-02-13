package pragmatico

import pragmatico.project.Status

class ProjectsController implements AuthenticatedController, ExceptionHandler {
  def index() {
    [projects: Project.findAll()]
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
