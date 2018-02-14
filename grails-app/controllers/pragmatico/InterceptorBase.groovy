package pragmatico

import grails.compiler.GrailsCompileStatic
import javax.servlet.http.HttpServletRequest

@GrailsCompileStatic
trait InterceptorBase {
  Account getAccountFromRequest(HttpServletRequest request) {
    def hash = JwtService.decodeFromAuthHeader(request.getHeader('Authorization'))
    if (hash && hash['id']) {
      Account.findById(hash['id'])
    }
  }

  boolean after() { true }

  void afterView() {
    // no-op
  }
}
