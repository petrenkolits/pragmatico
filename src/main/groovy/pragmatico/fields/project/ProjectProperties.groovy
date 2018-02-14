package pragmatico.fields.project

import grails.compiler.GrailsCompileStatic
import pragmatico.fields.project.embedds.*

@GrailsCompileStatic
class ProjectProperties {
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
}