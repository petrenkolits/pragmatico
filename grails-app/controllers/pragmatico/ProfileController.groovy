package pragmatico

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ProfileController {
  ProfileService profileService

  def update() {
    profileService.update(currentUser.id, request.JSON as Map)
  }

  protected Account getCurrentUser() {
    request.getAttribute('currentUser') as Account
  }
}
