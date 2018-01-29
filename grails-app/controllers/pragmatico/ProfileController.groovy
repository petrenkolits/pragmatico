package pragmatico

import grails.rest.*
import grails.converters.*

class ProfileController {
	static responseFormats = ['json']
	
  def update() {
    respond request.JSON
  }
}
