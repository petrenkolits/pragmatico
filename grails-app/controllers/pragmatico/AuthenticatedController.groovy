package pragmatico

trait AuthenticatedController {
  Account getCurrentUser() {
    // Hash  should be validated in AuthInterceptor before reaching this action
    def hash = JwtService.decodeFromAuthHeader(request.getHeader('Authorization'))
    Account.findById(hash['id'])
  }
}
