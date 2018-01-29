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
      respond([errors: e.errors.allErrors.toArray().join('\n')], status: 422)
    } catch (Exception e) {
      respond([errors: e.message], status: 422)
    }
  }

  def signIn() {
    def data = request.JSON

    try {
      respond([token: signInService.viaCreds(data.username, data.password)])
    } catch (Exception e) {
      respond([errors: e.message], status: 422)
    }
  }
}
