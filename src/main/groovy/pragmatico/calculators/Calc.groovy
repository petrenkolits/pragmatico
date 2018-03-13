package pragmatico.calculators

import groovy.transform.CompileStatic
import pragmatico.Project

@CompileStatic
class Calc {
  private Project project
  private Double currRating = 0.0d

  Calc() {
    throw new Exception('anon constructor call!!!')
  }

  Calc(Project project) {
    this.project = project
  }

  static RatingProvider from(TwEntity[] entities) {
    new Twittr(entities: entities)
  }

  static RatingProvider from(FbEntity[] entities) {
    new Facebook(entities: entities)
  }

  static RatingProvider from(BttalkEntity[] entities) {
    new Bttalk(entities: entities)
  }

  static def withProject(Project project, Closure cl) {
    Calc calc = new Calc(project)
    cl.delegate = calc
    cl()
    calc.applyRating()
  }

  def addRating(Double val) {
    this.currRating += val
  }

  def applyRating() {
    project.with {
      dynamicRating = currRating
      Double newRating = staticRating + currRating
      ratingChange = newRating - rating
      rating = newRating
    }
  }
}
