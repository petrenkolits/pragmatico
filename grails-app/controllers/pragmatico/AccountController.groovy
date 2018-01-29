package pragmatico

import grails.validation.ValidationException

class AccountController {
  def signUpService
  def signInService

  def signUp() {
    def data = request.JSON

    try {
      respond([token: signUpService.viaCreds(data.username, data.password)])
    } catch (ValidationException e) {
      respond([error: e.errors.fieldError.defaultMessage], status: 422)
    } catch (Exception e) {
      respond([error: e.message], status: 422)
    }
  }

  def signIn() {
    def data = request.JSON

    try {
      respond([token: signInService.viaCreds(data.username, data.password)])
    } catch (Exception e) {
      respond([error: e.message], status: 422)
    }
  }
}
