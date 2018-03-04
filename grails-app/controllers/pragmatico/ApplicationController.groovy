package pragmatico

import grails.compiler.GrailsCompileStatic
import grails.core.GrailsApplication
import grails.plugins.*
import pragmatico.social.scrapers.Facebook

@GrailsCompileStatic
class ApplicationController implements PluginManagerAware {

  GrailsApplication grailsApplication
  GrailsPluginManager pluginManager

  def index() {
    def fb = new Facebook(grailsApplication.config.getProperty('grails.social.fbToken'))
    [data: fb.getData('cocacola'), grailsApplication: grailsApplication, pluginManager: pluginManager]
  }
}
