package pragmatico.admin

import grails.compiler.GrailsCompileStatic
import pragmatico.AuthenticatedController

@GrailsCompileStatic
class AdminController implements AuthenticatedController {
	static responseFormats = ['json']
  static namespace = 'admin'
}
