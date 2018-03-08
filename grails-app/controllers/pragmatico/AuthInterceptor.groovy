package pragmatico

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class AuthInterceptor implements InterceptorBase {
  int order = HIGHEST_PRECEDENCE

  AuthInterceptor() {
    match(controller: 'projects')
  }

  boolean before() {
    log.info('before()')
    currentUser ?: response.sendError(401)
  }
}
