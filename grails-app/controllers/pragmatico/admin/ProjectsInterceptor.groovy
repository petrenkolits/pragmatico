package pragmatico.admin

import grails.compiler.GrailsCompileStatic
import pragmatico.Account
import pragmatico.InterceptorBase

@GrailsCompileStatic
class ProjectsInterceptor implements InterceptorBase {
  boolean before() {
    Account account = getAccountFromRequest(request)
    if (account && account.isAdmin) {
      request.setAttribute('currentUser', account)
      return true
    }

    response.sendError(401)
    false
  }
}
