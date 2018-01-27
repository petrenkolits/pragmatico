package pragmatico

import grails.gorm.transactions.Transactional
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

@Transactional
class JwtService {
  static String key = '1LbJel9K8QxZidUHQrEL16yCbrFxt/eVzI7t8JC8u7o='

  static String encode(Map<String, Object> data) {
    Jwts.builder()
      .addClaims(data)
      .signWith(SignatureAlgorithm.HS256, key)
      .compact()
  }

  static Object decode(String token) {
    Jwts.parser().setSigningKey(key).parseClaimsJws(token).body
  }
}
