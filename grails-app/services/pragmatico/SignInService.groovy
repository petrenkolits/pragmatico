package pragmatico

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional

@Transactional
@GrailsCompileStatic
class SignInService {

  String viaCreds(String username, String pwd) {
    Account account = Account.findByUsernameAndPassword(username, pwd.encodeAsSHA256() as String)

    if (!account) {
      return
    }

    JwtService.encode([id: account.id.toString()] as Map)
  }
}
