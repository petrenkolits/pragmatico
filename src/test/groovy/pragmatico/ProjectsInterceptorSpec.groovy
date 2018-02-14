package pragmatico

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ProjectsInterceptorSpec extends Specification implements InterceptorUnitTest<ProjectsInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test auth interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"auth")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }
}
