package pragmatico

import grails.rest.*
import grails.converters.*

class ProfileController implements  AuthenticatedController {
  def update() {
//    SampleJob.triggerNow([args: 'data'])
    println(currentUser)
    respond request.JSON
  }
}
