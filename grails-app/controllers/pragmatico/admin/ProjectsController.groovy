package pragmatico.admin

//import pragmatico.Project

class ProjectsController extends AdminController {
  def index() {
    [projects: Project.findAll()]
  }

  def show() {
    [project: Project.findById(params.id)]
  }
}
