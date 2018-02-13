package pragmatico

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ProfileController implements AuthenticatedController {
  ProfileService profileService

  def update() {
    profileService.update(currentUser.id, request.JSON as Map)
  }
}
