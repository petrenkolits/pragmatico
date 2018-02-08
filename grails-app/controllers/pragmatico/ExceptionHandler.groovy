package pragmatico

import grails.validation.ValidationException

trait ExceptionHandler {
  def handleValidationException(ValidationException e) {
    render view: '/validationError', model: [errors: e.errors]
  }

  def handleException(Exception e) {
    render view: '/exception', model: [exception: e]
  }
}
