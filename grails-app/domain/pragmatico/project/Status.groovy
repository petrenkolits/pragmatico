package pragmatico.project

import groovy.transform.CompileStatic

@CompileStatic
enum Status {
  PENDING('PENDING'),
  APPROVED('APPROVED'),
  DECLINED('DECLINED')

  final String status

  private Status(String status) {
    this.status = status
  }
}
