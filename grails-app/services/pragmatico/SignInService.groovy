package pragmatico

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import pragmatico.Account
import pragmatico.JwtService

@Transactional
@GrailsCompileStatic
class SignInService {

  def viaCreds(String username, String pwd) {
    if (!username || !pwd) {
      throw new Exception('Invalid credentials')
    }

    def account = Account.findByUsernameAndPassword(username, pwd.encodeAsSHA256() as String)

    if (!account) {
      throw new Exception('Invalid credentials')
    }

    JwtService.encode([id: account.id.toString()] as Map)
  }
}
