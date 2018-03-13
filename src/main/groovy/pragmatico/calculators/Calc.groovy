package pragmatico.calculators

import groovy.transform.CompileStatic
import pragmatico.Project

@CompileStatic
class Calc {
  private Project project
  private Double currRating = 0.0d

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
    Calc calc = new Calc(project: project)
    cl.delegate = calc
    cl()
    calc.applyRating()
  }

  def twRating(Double val) {
    this.currRating += val
  }

  def fbRating(Double val) {
    this.currRating += val
  }

  def btRating(Double val) {
    this.currRating += val
  }

  def applyRating() {
    project.with {
      currentDynamicRating = currRating
      Double newRating = initialRating + currRating
      ratingChange = newRating - rating
      rating = newRating
    }
  }
}
