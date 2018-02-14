package pragmatico.admin

import grails.compiler.GrailsCompileStatic
import pragmatico.Project
import pragmatico.admin.commands.project.*

@GrailsCompileStatic
class ProjectsController extends AdminController {
  def index(Index cmd) {
    render view: '/admin/projects/index', model: [result: cmd().result]
  }

  def show(Show cmd) {
    render view: '/admin/projects/show', model: [project: cmd().result]
  }
}
