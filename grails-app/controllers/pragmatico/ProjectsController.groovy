package pragmatico

import grails.compiler.GrailsCompileStatic
import pragmatico.commands.project.Create
import pragmatico.commands.project.Index

@GrailsCompileStatic
class ProjectsController implements ExceptionHandler {
  def index(Index cmd) {
    [projects: cmd().result]
  }

  def save(Create cmd) {
    cmd(request.getAttribute('currentUser') as Account).hasErrors() ? renderErrors(cmd.errors) : [project: cmd.result]
  }

  def show() {
    [project: Project.findById(params.id)]
  }
}
