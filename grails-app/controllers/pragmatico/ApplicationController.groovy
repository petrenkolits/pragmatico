package pragmatico

import grails.compiler.GrailsCompileStatic
import grails.core.GrailsApplication
import grails.plugins.*
import pragmatico.social.scrapers.Facebook
import pragmatico.social.scrapers.Twittr

@GrailsCompileStatic
class ApplicationController implements PluginManagerAware {

  GrailsApplication grailsApplication
  GrailsPluginManager pluginManager
  Facebook facebook
  Twittr twittr

  def index() {
    def startDate = (new Date() - 3).clearTime()
    [
      fb: facebook.getData('popularjournal', startDate),
      tw: twittr.getData('neo4j', startDate),
      grailsApplication: grailsApplication,
      pluginManager: pluginManager
    ]
  }
}
