package pragmatico

import grails.compiler.GrailsCompileStatic
import pragmatico.commands.account.*

@GrailsCompileStatic
class AccountController implements ExceptionHandler {
  def signUp(SignUp cmd) {
    cmd().hasErrors() ? renderErrors(cmd.errors) : [token: cmd.result]
  }

  def signIn(SignIn cmd) {
    cmd().hasErrors() ? renderErrors(cmd.errors) : [token: cmd.result]
  }
}
