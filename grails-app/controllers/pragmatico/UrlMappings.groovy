package pragmatico

class UrlMappings {

  static mappings = {
    post "/sign-up"(controller: 'account', action: 'signUp')
    post "/sign-in"(controller: 'account', action: 'signIn')
    put  "/api/profile"(controller: 'profile', action: 'update')

    get "/api/projects"(controller: 'projects', action: 'index')
    post "/api/projects"(controller: 'projects', action: 'create')

    get "/api/admin/projects"(controller: 'projects', action: 'index', namespace: 'admin')
    get "/api/admin/projects/$id"(controller: 'projects', action: 'show', namespace: 'admin')

//    delete "/$controller/$id(.$format)?"(action: "delete")
//    get "/$controller(.$format)?"(action: "index")
//    get "/$controller/$id(.$format)?"(action: "show")
//    post "/$controller(.$format)?"(action: "save")
//    put "/$controller/$id(.$format)?"(action: "update")
//    patch "/$controller/$id(.$format)?"(action: "patch")

    "/"(controller: 'application', action: 'index')
    "500"(view: '/error')
    "404"(view: '/notFound')
  }
}
