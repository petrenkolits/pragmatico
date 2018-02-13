package pragmatico.commands


import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable

@GrailsCompileStatic
class Interactionable implements Validateable {
  Object result

  static constraints = {
    result bindable: false, nullable: true
  }
}
