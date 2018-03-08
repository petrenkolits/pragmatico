package pragmatico.social.scrapers

import groovy.transform.CompileStatic
import groovy.util.slurpersupport.GPathResult
import org.ccil.cowan.tagsoup.Parser
import pragmatico.calculatators.BttalkEntity

//println page.depthFirst().find { it.text() == 'North America'}
//println page.depthFirst().find { it.text().contains('North America')}



//System.setProperty('javax.xml.accessExternalSchema', 'all')
//System.setProperty('javax.xml.accessExternalDTD', 'all')
//
//URL url = "https://bitcointalk.org/index.php?board=67.0".toURL()
//
//def tx = new XmlSlurper(false, false, true).with { x ->
//  url.openConnection().with {
//    // Pretend to be an old Firefox version
//    setRequestProperty("User-Agent", "Firefox/2.0.0.4")
//    // Get a reader
//    inputStream.withReader( 'UTF-8' ) {
//      // and parse it with the XmlSlurper
//
//      parse it
//    }
//  }
//}
//println tx.toString()


@CompileStatic
class Bttalk {
  BttalkEntity[] getData(String pageUrl, Date startDate) {
    if (!pageUrl) {
      return [] as BttalkEntity[]
    }
    URL url = pageUrl.toURL()
    GPathResult result = new XmlSlurper(new Parser()).with { x ->
      url.openConnection().with {
        setRequestProperty("User-Agent", "Firefox/2.0.0.4")
        inputStream.withReader( 'UTF-8' ) { parse it }
      }
    }
    [] as BttalkEntity[]
  }
}
