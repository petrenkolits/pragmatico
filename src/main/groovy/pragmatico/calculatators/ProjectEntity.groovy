package pragmatico.calculatators

import groovy.transform.CompileStatic

@CompileStatic
class ProjectEntity {
  String _id
  String fblink
  String twitterlink
  String bitcoinlink

  String getFblink() {
    fblink ? fblink.trim().split('/').findAll { it }.last() : super
  }

  String getTwitterlink() {
    twitterlink ? twitterlink.trim().split('/').findAll { it }.last() : super
  }

  String getId() {
    _id
  }
}
