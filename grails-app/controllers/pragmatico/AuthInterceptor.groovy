package pragmatico

class AuthInterceptor {
  AuthInterceptor() {
    matchAll().except(controller: "account")
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
