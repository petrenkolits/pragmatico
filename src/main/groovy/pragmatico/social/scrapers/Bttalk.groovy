package pragmatico.social.scrapers

import groovy.transform.CompileDynamic
import org.ccil.cowan.tagsoup.Parser
import com.joestelmach.natty.Parser as DateParser
import groovy.util.slurpersupport.GPathResult
import pragmatico.calculators.BttalkEntity

@CompileDynamic
class Bttalk {
  static String nextLinkCss = 'prevnext'
  static String nextLinkTag = 'span'
  static String lastPostCss = ' lastpostcol'
  static String lastPostSplitter = 'by'

  static String nextPage(GPathResult result) {
    result.depthFirst().findAll { it.name() == nextLinkTag && it.@class == nextLinkCss }*.a*.@href.unique().last()
  }

  static List getPosts(GPathResult result) {
    if (!result) {
      return null
    }
    result.depthFirst().findAll {
      it.@class.toString().indexOf(lastPostCss) > -1
    }*.text()*.split(lastPostSplitter)*.first()
  }

  static Date[] fetchData(pageUrl, Date startDate) {
    if (!pageUrl) {
      return [] as Date[]
    }
    GPathResult result
    URL url = pageUrl.toURL()
    Date[] res = url.openConnection().with {
      setRequestProperty("User-Agent", "Firefox/2.0.0.4")
      inputStream.withReader( 'UTF-8' ) {
        result = new XmlSlurper(new Parser()).parseText(it.text)
        getPosts(result).collect { String date ->
          new DateParser().parse(date).with {
            first().getDates().first()
          }
        }.findAll { it >= startDate } as Date[]
      }
    }
    if (res.size() != 0 && res.last() > startDate) {
      println "Going to: ${nextPage(result)}"
      res += fetchData(nextPage(result), startDate)
    }
    res
  }

  BttalkEntity[] getData(String pageUrl, Date startDate) {
    if (!pageUrl) {
      return [] as BttalkEntity[]
    }
    fetchData(pageUrl, startDate).collect { Date d -> new BttalkEntity(postDate: d) } as BttalkEntity[]
  }
}
