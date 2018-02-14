package pragmatico

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
trait AuthenticatedController {
  Account getCurrentUser() {
//    request.currentUser as Account
//    // Hash  should be validated in ProjectsInterceptor before reaching this action
//    def hash = JwtService.decodeFromAuthHeader(request.getHeader('Authorization'))
//    Account.findById(hash['id'])
  }
}
