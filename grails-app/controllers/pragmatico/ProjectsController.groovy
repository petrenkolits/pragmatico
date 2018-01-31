package pragmatico

import grails.rest.*
import grails.converters.*

class ProjectsController implements AuthenticatedController {
  def index() {
    [projects: currentUser.projects]
  }

  def create(Project project) {
    project.account = currentUser
    if (project.validate()) {
      project.save()
    } else {
      render view: '/validationError', model: [errors: project.errors]
    }
  }
}
