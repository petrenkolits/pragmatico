package pragmatico

import grails.rest.*
import grails.converters.*

class ProjectsController implements AuthenticatedController, ExceptionHandler {
  def index() {
    [projects: currentUser.projects]
  }

  def create(Project project) {
    project.account = currentUser
    project.validate() ? project.save()  : renderErrors(project.errors)
  }
}
