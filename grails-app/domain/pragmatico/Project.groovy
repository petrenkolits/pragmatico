package pragmatico

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id', includeNames = true, includePackage = false)
class Project implements Serializable {
  ObjectId id
  Date dateCreated
  Date lastUpdated

  static constraints = {
  }

  static mapping = {
  }
}
