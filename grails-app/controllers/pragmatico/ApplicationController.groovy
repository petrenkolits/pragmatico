package pragmatico

import grails.compiler.GrailsCompileStatic
import grails.core.GrailsApplication
import grails.plugins.*

@GrailsCompileStatic
class ApplicationController implements PluginManagerAware {

  GrailsApplication grailsApplication
  GrailsPluginManager pluginManager

  def index() {
    [grailsApplication: grailsApplication, pluginManager: pluginManager]
  }
}
