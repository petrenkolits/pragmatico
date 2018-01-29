package pragmatico

class AuthInterceptor {
  AuthInterceptor() {
    matchAll().except()
  }

  boolean before() {
    println('oooooops')
    true
  }

  boolean after() { true }

  void afterView() {
    // no-op
  }
}
