package pragmatico

import pragmatico.commands.account.SignIn

class AccountController implements ExceptionHandler {
  def signUpService

  def signUp() {
    def data = request.JSON
    [token: signUpService.viaCreds(data.username, data.password)]
  }

  def signIn(SignIn cmd) {
    cmd.hasErrors() ? renderErrors(cmd.errors) : [model: cmd]
  }
}
