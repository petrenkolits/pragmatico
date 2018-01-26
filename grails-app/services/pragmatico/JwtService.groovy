package pragmatico

import grails.gorm.transactions.Transactional
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.impl.crypto.MacProvider
import java.security.Key

@Transactional
class JwtService {

  static String encode() {
    Key key = MacProvider.generateKey()

    Jwts.builder()
      .setSubject("Joe")
      .signWith(SignatureAlgorithm.HS256, null)
      .compact()
  }
}
