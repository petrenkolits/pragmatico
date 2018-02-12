package pragmatico

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId
import pragmatico.project.*

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id', includeNames = true, includePackage = false)
class Project implements Serializable {
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
  Integer softcap
  Integer hardcap
  Integer tokenbaseprice
  Integer tokensize
  Date roadmapEnd
  Date startdate
  Date enddate
  Date preIcoStart
  Date icoStart
  Date icoEnd

  List<Category> categories
  List<Step> steps
  List<Period> periods
  List<Founder> founders
  List<Advisor> advisors
  Status status

  static embedded = ['categories', 'steps', 'periods', 'founders', 'advisors']

  static belongsTo = [account: Account]

  static constraints = {
    twitterlink blank: true, nullable: true
    bitcoinlink blank: true, nullable: true
    telegramlink blank: true, nullable: true
    fblink blank: true, nullable: true
    youtube blank: true, nullable: true
    status bindable: false, nullable: true
  }

  static mapping = {
    collection 'projects'
    account attr: 'accountId', index: true
    status defaultValue: Status.PENDING, enumType: 'string', index: true
  }
}
