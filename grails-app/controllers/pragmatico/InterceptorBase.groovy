package pragmatico

import grails.artefact.Interceptor
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
trait InterceptorBase implements Interceptor {
  Account getAccountFromRequest() {
    def hash = JwtService.decodeFromAuthHeader(request.getHeader('Authorization'))
    if (hash && hash['id']) {
      Account.findById(hash['id'])
    }
  }

  Account getCurrentUser() {
    Account account = request.getAttribute('currentUser') as Account
    account ?: setCurrentUser(accountFromRequest)
  }

  Account setCurrentUser(Account account) {
    request.setAttribute('currentUser', account)
    account
  }

  boolean after() { true }

  void afterView() {
    // no-op
  }
}
