package pragmatico

class BootStrap {

  def init = { servletContext ->
    def me = new Account(username: 'test@test.com', password: '111111', roles: ['admin']).save()
    println(me)
  }

  def destroy = {
  }
}
