package pragmatico

import grails.validation.ValidationException
import org.springframework.validation.Errors

trait ExceptionHandler {
  def handleValidationException(ValidationException e) {
    renderErrors e.errors
  }

  def handleException(Exception e) {
    render view: '/exception', model: [exception: e]
  }

  def renderErrors(Errors errors) {
    render view: '/validationError', model: [errors: errors]
  }
}
