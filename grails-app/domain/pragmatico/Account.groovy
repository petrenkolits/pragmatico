package pragmatico

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic
import org.bson.types.ObjectId

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class Account implements Serializable {
  ObjectId id
  String username
  String password
  Set<String> roles
  boolean enabled = true
  boolean accountExpired
  boolean accountLocked
  boolean passwordExpired
  Date dateCreated
  Date lastUpdated

  static constraints = {
    username nullable: false, blank: false, unique: true
    password nullable: false, blank: false, password: true
  }

  static mapping = {
    collection 'accounts'
    username index: true, indexAttributes: [unique: true, dropDups: true]
    password index: true
  }

  static hasMany = [projects: Project]
}
