package pragmatico.admin

import grails.compiler.GrailsCompileStatic
import pragmatico.Project

@GrailsCompileStatic
class ProjectsController extends AdminController {
  def index() {
    render view: '/admin/projects/index', model: [projects: Project.findAll()]
  }

  def show() {
    render view: '/admin/projects/show', model: [project: Project.findById(params.id)]
  }
}
