package pragmatico

import grails.validation.ValidationException

class AccountController {
  def signUpService
  def signInService

  def signUp() {
    def data = request.JSON

    try {
      [token: signUpService.viaCreds(data.username, data.password)]
    } catch (ValidationException e) {
      render view: '/validationError', model: [errors: e.errors]
    } catch (Exception e) {
      render view: '/error', model: [error: e]
    }
  }

  def signIn() {
    def data = request.JSON

    try {
      [token: signInService.viaCreds(data.username, data.password)]
    } catch (Exception e) {
      render view: '/exception', model: [exception: e]
    }
  }
}
