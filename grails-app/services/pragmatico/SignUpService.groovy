package pragmatico

import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

@Transactional
class SignUpService {

  def viaCreds(String username, String pwd) {
    if (!username || !pwd) {
      throw new Exception('Invalid credentials')
    }

    def account = new Account(username: username, password: pwd.encodeAsSHA256() as String)

    if (!account.validate()) {
      throw new ValidationException('Failed to create account', account.errors)
    }

    account.save()
    JwtService.encode([id: account.id])
  }
}
