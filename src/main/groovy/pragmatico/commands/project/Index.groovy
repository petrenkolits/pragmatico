package pragmatico.commands.project

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import pragmatico.Account
import pragmatico.Project

import pragmatico.fields.project.embedds.Status

@GrailsCompileStatic
class Index implements Validateable {
  String type
  String sort = 'rating'
  String order = 'desc'
  Integer limit = 6
  List<Project> result

  static Map<String, Closure<List<Project>>> projectTypeFilter = [
    mostactive: { -> Project.findAllByStatus Status.APPROVED,
      [max: 6, sort: 'dynamicRatingChange', order: 'desc'] },
    passive: { -> },
    biggestratio: { -> },
    ongoingsinking: { -> },
    mostperspective: { -> },
    upcomingsinking: { -> }
  ]

  static constraints = {
    type blank: true, nullable: true
    result bindable: false, nullable: true
  }

  Index call(Account currentUser = null) {
    setResult currentUser ? getByUser(currentUser) : byType
    this
  }

  List<Project> getByType() {
    if (projectTypeFilter[type]) {
      projectTypeFilter[type].call()
    } else {
      Project.findAllByStatus(Status.APPROVED, [max: limit, sort: sort, order: order])
    }
  }

  List<Project> getByUser(Account user) {
    Project.findAllByAccount(user, [max: limit, sort: sort, order: order])
  }
}
