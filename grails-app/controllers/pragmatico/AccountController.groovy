package pragmatico

import pragmatico.commands.account.*

class AccountController implements ExceptionHandler {
  def signUp(SignUp cmd) {
    cmd().hasErrors() ? renderErrors(cmd.errors) : [token: cmd.result]
  }

  def signIn(SignIn cmd) {
    cmd.hasErrors() ? renderErrors(cmd.errors) : [model: cmd]
  }
}
