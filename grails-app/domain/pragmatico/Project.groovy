package pragmatico

import grails.compiler.GrailsCompileStatic
import grails.databinding.BindingFormat
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId

//@GrailsCompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id', includeNames = true, includePackage = false)
class Project implements Serializable {

  class Category {
    String title
    Boolean isChecked
  }

  class Step {
    String title
    Boolean isDone
  }

  class Period {
    String name
    String duration
    Integer sale
  }

  class TeamMember {
    String photo
    String name
    String position
  }

  class Advisor {
    String photo
    String name
    String position
  }

  ObjectId id
  Date dateCreated
  Date lastUpdated

  String logo
  String projectName
  String whatTheyDo
  String mainKey
  String site
  String similarProjects
  String differenceFromCompetitors
  String marketVolume
  String projectState
  String roadmapUrl
  String whyBlockchain
  String whatTokenFor
  String restTokens
  Integer softCap
  Integer hardCap

  @BindingFormat("yyyy-MM-dd")
  Date roadmapEnd
  @BindingFormat("yyyy-MM-dd'T'hh:mm")
  Date preIcoStart
  @BindingFormat("yyyy-MM-dd'T'hh:mm")
  Date icoStart
  @BindingFormat("yyyy-MM-dd'T'hh:mm")
  Date icoEnd


  List<Category> categories
  List<Step> steps
  List<Period> periods
  List<TeamMember> teamMembers
  List<Advisor> advisors

  static embedded = ['categories', 'steps', 'periods', 'teamMembers', 'advisors']

  static belongsTo = [account: Account]

  static constraints = {
  }

  static mapping = {
  }
}
