package pragmatico.social.scrapers

import com.restfb.*
import com.restfb.types.Post
import groovy.transform.CompileStatic
import pragmatico.calculatators.FbEntity

//@Grab(group='org.ccil.cowan.tagsoup', module='tagsoup', version='1.2')
//def parser = new XmlSlurper(new org.ccil.cowan.tagsoup.Parser())
//
//def page = parser.parse('http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/SR1a/eclipse-jee-luna-SR1a-linux-gtk-x86_64.tar.gz')
//
//println page.depthFirst().find { it.text() == 'North America'}
//println page.depthFirst().find { it.text().contains('North America')}



//System.setProperty('javax.xml.accessExternalSchema', 'all')
//System.setProperty('javax.xml.accessExternalDTD', 'all')
//
//URL url = "https://bitcointalk.org/index.php?board=67.0".toURL()
//
def tx = new XmlSlurper(false, false, true).with { x ->
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

//URL url = "https://bitcointalk.org/index.php?board=67.0".toURL()
//
//def tx = new XmlSlurper(new org.ccil.cowan.tagsoup.Parser()).with { x ->
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
//println tx //*[@id="bodyarea"]/div[2]/table
//println tx.'**'.find { it.table }

@CompileStatic
class Bttalk {
}
