package pragmatico

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class AuthInterceptor {
  AuthInterceptor() {
    matchAll().except(controller: 'account').except(controller: 'application').except(view: '/error').except(view: '/notFound')
  }

  boolean before() {
    def hash = JwtService.decodeFromAuthHeader(request.getHeader('Authorization'))

    if (hash && hash['id']) {
      println("User ID: ${hash['id']}")
      return true
    }

    response.sendError(401)
    false
  }

  boolean after() { true }

  void afterView() {
    // no-op
  }
}
