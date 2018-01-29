package pragmatico

import grails.gorm.transactions.Transactional

@Transactional
class ProfileService {

  def update(String accountId, Map data) {
    def account = Account.findById(accountId)
  }
}
