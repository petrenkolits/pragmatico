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

  class Founder {
    String photo
    String name
    String desc
    String exp
    String fblink
    String twitterlink
    String linkedinlink
  }

  class Advisor {
    String photo
    String name
    String desc
    String exp
    String fblink
    String twitterlink
    String linkedinlink
  }

  ObjectId id
  Date dateCreated
  Date lastUpdated

  String logo
  String name
  String shortdesc
  String fulldesc
  String sitelink
  String whitepaper
  String offer
  String responsible
  String email
  String fblink
  String twitterlink
  String bitcoinlink
  String telegramlink
  String youtube
  String ticker
  String whyBlockchain
  String whatTokenFor
  String currencies
  String restTokens
  Integer softCap
  Integer hardCap
  Integer tokenbaseprice
  Integer tokensize

  @BindingFormat("yyyy-MM-dd")
  Date roadmapEnd
  @BindingFormat("yyyy-MM-dd'T'hh:mm")
  Date startdate
  @BindingFormat("yyyy-MM-dd'T'hh:mm")
  Date enddate
  @BindingFormat("yyyy-MM-dd'T'hh:mm")
  Date preIcoStart
  @BindingFormat("yyyy-MM-dd'T'hh:mm")
  Date icoStart
  @BindingFormat("yyyy-MM-dd'T'hh:mm")
  Date icoEnd


  List<Category> categories
  List<Step> steps
  List<Period> periods
  List<Founder> founders
  List<Advisor> advisors

  static embedded = ['categories', 'steps', 'periods', 'founders', 'advisors']

  static belongsTo = [account: Account]

  static constraints = {
  }

  static mapping = {
  }
}
