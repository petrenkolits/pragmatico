package pragmatico.commands.account

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import groovy.transform.Memoized
import pragmatico.SignInService

@GrailsCompileStatic
class SignIn implements Validateable, Serializable {
  SignInService signInService

  String username
  String password

  static constraints = {
    username blank: false
    password blank: false
  }

  @Memoized
  String getToken() {
    if (username && password) {
      signInService.viaCreds username, password
    }
  }
}
