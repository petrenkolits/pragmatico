package pragmatico.admin

import grails.compiler.GrailsCompileStatic
import pragmatico.Account

@GrailsCompileStatic
class AdminController {
	static responseFormats = ['json']
  static namespace = 'admin'

  protected Account getCurrentUser() {
    request.getAttribute('currentUser') as Account
  }
}
