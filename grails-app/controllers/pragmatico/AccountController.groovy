package pragmatico

import grails.rest.*
import grails.converters.*

class AccountController {
	static responseFormats = ['json', 'xml']
	
  def signUp() {
    print(JwtService.encode())
    respond JwtService.encode()
  }
}
