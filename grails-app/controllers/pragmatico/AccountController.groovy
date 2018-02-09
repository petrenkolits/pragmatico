package pragmatico

import pragmatico.commands.account.SignIn

class AccountController implements ExceptionHandler {
  def signUpService
  def signInService

  def signUp() {
    def data = request.JSON
    [token: signUpService.viaCreds(data.username, data.password)]
  }

  def signIn(SignIn cmd) {
    def data = request.JSON
    [token: signInService.viaCreds(data.username, data.password)]
  }
}
