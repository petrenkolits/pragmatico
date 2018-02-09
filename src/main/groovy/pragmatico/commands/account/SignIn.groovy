package pragmatico.commands.account

import grails.validation.Validateable
import groovy.transform.CompileStatic

@CompileStatic
class SignIn implements Validateable {
  def signInService

  String username
  String password
  String token

  static constraints = {
    username blank: false, validator: { val, obj ->
      obj.token = obj.signInService.viaCreds(obj.username, obj.password)
      obj.token
    }
  }
}