package pragmatico.fields.project.embedds

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Advisor {
  String photo
  String name
  String desc
  String exp
  String fblink
  String twitterlink
  String linkedinlink

  static constraints = {
  }
}
