package pragmatico.project

import groovy.transform.CompileStatic

@CompileStatic
enum Status {
  PENDING('pending'),
  APPROVED('approved'),
  DECLINED('declined'),

  final String id
  private Status(String id) { this.id = id }
}
