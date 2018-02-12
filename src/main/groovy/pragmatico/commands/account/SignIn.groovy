package pragmatico.commands.account

import grails.compiler.GrailsCompileStatic
import pragmatico.Account
import pragmatico.JwtService
import pragmatico.commands.Interactionable

@GrailsCompileStatic
class SignIn extends Interactionable {
  String username
  String password

  static constraints = {
    importFrom Interactionable
    username blank: false
    password blank: false
  }

  def call() {
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
