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

  def index() {
    def fb = new Facebook(grailsApplication.config.getProperty('grails.social.fb.token'))
    def tw = new Twittr(
      grailsApplication.config.getProperty('grails.social.tw.cKey'),
      grailsApplication.config.getProperty('grails.social.tw.cSec'),
      grailsApplication.config.getProperty('grails.social.tw.aTok'),
      grailsApplication.config.getProperty('grails.social.tw.tSec'))
    [
      fb: fb.getData('cocacola'),
      tw: tw.getData('neo4j'),
      grailsApplication: grailsApplication,
      pluginManager: pluginManager
    ]
  }
}
