package pragmatico.admin

import pragmatico.AuthenticatedController

class AdminController implements AuthenticatedController {
	static responseFormats = ['json']
  static namespace = 'admin'
}
