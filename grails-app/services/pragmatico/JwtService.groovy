package pragmatico

import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

@Transactional
@GrailsCompileStatic
class JwtService {
  static String key = '1LbJel9K8QxZidUHQrEL16yCbrFxt/eVzI7t8JC8u7o='

  static String encode(Map data) {
    Jwts.builder()
      .addClaims(data)
      .signWith(SignatureAlgorithm.HS256, key)
      .compact()
  }

  static Object decode(String token) {
    try {
      Jwts.parser().setSigningKey(key).parseClaimsJws(token).body
    } catch(Exception all) {
      println('JwtService:: failed to decode token!')
//      log.fatal('JwtService:: failed to decode token!')
    }
  }

  static Object decodeFromAuthHeader(String authHeader) {
    if (authHeader) {
      def token = authHeader.split(' ').last()

      if (token) {
        println("Token: ${token}")
        return decode(token)
      }
    }
  }
}
