package pragmatico

import pragmatico.project.Status

class ProjectsController implements AuthenticatedController, ExceptionHandler {
  def index() {
    [projects: currentUser.projects]
  }

  def create(Project project) {
    project.account = currentUser
    project.status = Status.PENDING
    project.validate() ? project.save() : renderErrors(project.errors)
  }
}
