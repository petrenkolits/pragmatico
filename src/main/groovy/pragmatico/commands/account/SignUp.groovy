package pragmatico.commands.account

import grails.compiler.GrailsCompileStatic
import pragmatico.Account
import pragmatico.JwtService
import pragmatico.commands.Interactionable

@GrailsCompileStatic
class SignUp extends Interactionable {
  String username
  String password

  static constraints = {
    importFrom Interactionable
    username blank: false
    password blank: false
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
