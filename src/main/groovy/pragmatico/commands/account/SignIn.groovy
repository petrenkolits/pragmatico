package pragmatico.commands.account

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import pragmatico.Account
import pragmatico.JwtService

@GrailsCompileStatic
class SignIn implements Validateable {
  String username
  String password
  String result

  static constraints = {
    username blank: false
    password blank: false
    result bindable: false, nullable: true
  }

  SignIn call() {
    if (!hasErrors()) {
      Account account = Account.findByUsernameAndPassword(username, password.encodeAsSHA256() as String)
      if (account) {
        setResult JwtService.encode([id: account.id.toString()] as Map)
      } else {
        errors.rejectValue('result', 'signIn.token.nullable')
      }
    }
    this
  }
}
