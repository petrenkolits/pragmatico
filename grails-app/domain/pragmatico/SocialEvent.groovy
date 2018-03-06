package pragmatico

import grails.compiler.GrailsCompileStatic
import org.bson.types.ObjectId

@GrailsCompileStatic
class SocialEvent {
  ObjectId id
  Date dateCreated
  Date lastUpdated
  String source
  String foreignId
  List<Map> data
  Float rating

  static belongsTo = [account: Account, project: Project]

  static mapping = {
    collection 'socialEvents'
    source index: true
    foreignId index: true
    account attr: 'accountId', index: true
    project attr: 'projectId', index: true
  }
}
