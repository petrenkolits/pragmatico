package pragmatico

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ProjectsInterceptor {
  boolean before() {
    def hash = JwtService.decodeFromAuthHeader(request.getHeader('Authorization'))

    if (hash && hash['id']) {
      Account account = Account.findById(hash['id'])
      if (account) {
        println("User ID: ${hash['id']}")
        request.setAttribute('currentUser', account)
        return true
      }
    }

    response.sendError(401)
    false
  }

  boolean after() { true }

  void afterView() {
    // no-op
  }
}
