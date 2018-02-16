package pragmatico

import grails.gorm.transactions.Transactional
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

@Transactional
class FacepalmService {

//    def serviceMethod() {
//
//    }

  def show_responce() {
    RestBuilder rest = new RestBuilder()
    println("was here ------->")
    String url = "https://graph.facebook.com/v2.12/me?access_token=EAACEdEose0cBANJqU8vttjGcoN7sj2ZBMNiXTbLPc0x5bU5ZCicDZBvNA73rSOdWTOiAdOkq01wZCJz5YZAjWWV2KkyrcC124TbF7CKJLUnCEOajEw6GHmYJCjRvHGTHyZC1Vzzfmq4aK3oTqifEsN4WZBZByBd7GqoVskEZBvSTnPXUhyOBdYlFYrXK9KGZA84UXZB0EtC2tOpHQZDZD\""
    RestResponse restResponse = rest.get(url)
    return restResponse.json
  }
}
