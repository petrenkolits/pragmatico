package pragmatico.commands.project

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import pragmatico.Account
import pragmatico.Project
import pragmatico.StaticRatingCalculatorService
import pragmatico.fields.project.ProjectProperties

@GrailsCompileStatic
class Create extends ProjectProperties implements Validateable {
  Project result
  StaticRatingCalculatorService staticRatingCalculatorService

  static constraints = {
    twitterlink blank: true, nullable: true
    bitcoinlink blank: true, nullable: true
    telegramlink blank: true, nullable: true
    fblink blank: true, nullable: true
    youtube blank: true, nullable: true
    result bindable: false, nullable: true
    version bindable: false, nullable: true // weird stuff
  }

  Create call(Account account) {
    if (!hasErrors()) {
      Project project = new Project(this.properties)
      project.account = account
      if (project.validate()) {
        project.staticRating = staticRatingCalculatorService.perform(project)
        project.save() ? setResult(project) : setErrors(project.errors)
      } else {
        setErrors(project.errors)
      }
    }
    this
  }
}
