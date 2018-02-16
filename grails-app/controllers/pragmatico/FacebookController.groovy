package pragmatico


import grails.rest.*
import grails.converters.*

class FacebookController {
	static responseFormats = ['json', 'xml']
    def facepalmService
	
    def index() {
        render facepalmService.show_responce() as JSON
    }
}
