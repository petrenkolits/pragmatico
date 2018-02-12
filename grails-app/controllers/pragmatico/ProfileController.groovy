package pragmatico

class ProfileController implements AuthenticatedController {
  ProfileService profileService

  def update() {
    profileService.update(currentUser.id, request.JSON as Map)
  }
}
