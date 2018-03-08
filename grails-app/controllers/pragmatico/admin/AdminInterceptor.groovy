package pragmatico.admin

import grails.compiler.GrailsCompileStatic
import pragmatico.InterceptorBase

@GrailsCompileStatic
class AdminInterceptor implements InterceptorBase {
  AdminInterceptor() {
    match(namespace: 'admin')
  }

  boolean before() {
    log.info('before()')
    currentUser?.isAdmin || response.sendError(401)
  }
}
