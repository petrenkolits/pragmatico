package pragmatico

class UrlMappings {

  static mappings = {
    group '/api', {
      post "/sign-up"(controller: 'account', action: 'signUp')
      post "/sign-in"(controller: 'account', action: 'signIn')
      get "/my-projects"(controller: 'projects', action: 'myProjects')
      put "/profile"(controller: 'profile', action: 'update')

      "/projects"(resources: 'projects', includes: ['index', 'save', 'show'])

      group '/admin', {
        "/projects"(resources: 'projects', namespace: 'admin', includes: ['index', 'show'])
      }

//    delete "/$controller/$id(.$format)?"(action: "delete")
//    get "/$controller(.$format)?"(action: "index")
//    get "/$controller/$id(.$format)?"(action: "show")
//    post "/$controller(.$format)?"(action: "save")
//    put "/$controller/$id(.$format)?"(action: "update")
//    patch "/$controller/$id(.$format)?"(action: "patch")

      "/"(controller: 'application', action: 'index')
    }
    "500"(view: '/error')
    "404"(view: '/notFound')
  }
}
