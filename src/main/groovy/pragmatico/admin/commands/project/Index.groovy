package pragmatico.admin.commands.project

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import pragmatico.Project
import static com.mongodb.client.model.Projections.fields
import static com.mongodb.client.model.Projections.include

@GrailsCompileStatic
class Index implements Validateable {
  Integer offset = 0
  Integer limit = 10
  Map result

  static constraints = {
    result bindable: false, nullable: true
  }

  Index call() {
    // List<Project> res = Project.findAll(max: limit, offset: offset, sort: 'lastUpdated', order: 'desc') { }
    // we do not need to instantiate project models actually, so deal with mongo doc and fetch only required fields
    List res = Project.collection.find()
      .projection(fields(include('name', 'status')))
      .limit(limit).skip(offset).toList().collect { doc ->
        [id: doc._id.toString(), name: doc.name, status: doc.status]
      }
    setResult documentList: res, metadata: [total: Project.count(), limit: limit, offset: offset]
    this
  }
}
