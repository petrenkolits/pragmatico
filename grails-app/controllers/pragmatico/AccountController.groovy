package pragmatico

import grails.rest.*
import grails.converters.*

import grails.validation.ValidationException

class AccountController {
  static responseFormats = ['json']
  def signUpService
  def signInService

  def signUp() {
    def data = request.JSON

    try {
      def t = signUpService.viaCreds(data.username, data.password)
      render(contentType: 'application/json', status: 201) {
        token t
      }
    } catch (ValidationException e) {
      render(contentType: 'application/json', status: 422) {
        errors e.errors.allErrors.toArray().join('\n')
      }
    } catch (Exception e) {
      render(contentType: "application/json", status: 422) {
        errors e.message
      }
    }
  }

  def signIn() {
    def data = request.JSON

    try {
      def t = signInService.viaCreds(data.username, data.password)
      render(contentType: 'application/json', status: 200) {
        token t
      }
    } catch (Exception e) {
      render(contentType: "application/json", status: 422) {
        errors e.message
      }
    }
  }
}
