package pragmatico.commands.account

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import pragmatico.Account
import pragmatico.JwtService

@GrailsCompileStatic
class SignUp implements Validateable {
  String username
  String password
  String result

  static constraints = {
    username blank: false
    password blank: false
    result bindable: false, nullable: true
  }

  SignUp call() {
    if (!hasErrors()) {
      Account account = new Account(username: username, password: password.encodeAsSHA256() as String, roles: ['user'])
      if (account.save()) {
        setResult JwtService.encode([id: account.id.toString()] as Map)
      } else {
        setErrors account.errors
      }
    }
    this
  }
}
