package pragmatico

import grails.compiler.GrailsCompileStatic
import pragmatico.commands.project.Create
import pragmatico.commands.project.Index
import pragmatico.commands.project.Show

@GrailsCompileStatic
class ProjectsController implements ExceptionHandler {
  def index(Index cmd) {
    [projects: cmd().result]
  }

  def save(Create cmd) {
    cmd(currentUser).hasErrors() ? renderErrors(cmd.errors) : [project: cmd.result]
  }

  def show(Show cmd) {
    [project: cmd().result]
  }

  private Account getCurrentUser() {
    request.getAttribute('currentUser') as Account
  }
}
