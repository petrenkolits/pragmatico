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
  static String userAgent = 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/604.5.6 (KHTML, like Gecko) Version/11.0.3 Safari/604.5.6'

  static String nextPage(GPathResult result) {
    if (!result) {
      return null
    }
    result.depthFirst().findAll {
      it.name() == nextLinkTag && it.@class == nextLinkCss
    }*.a*.@href.unique().last()
  }

  static List getPostsDates(GPathResult result) {
    if (!result) {
      return null
    }
    result.depthFirst().findAll {
      it.@class.toString().indexOf(lastPostCss) > -1
    }*.text()*.split(lastPostSplitter)*.first()
  }

  static <T> T withUrlReader(URL url, Closure<T> closure) {
    url.openConnection().with {
      setRequestProperty('User-Agent', userAgent)
      inputStream.withReader('UTF-8') {
        closure.call it
      }
    }
  }

  static Date[] fetchData(pageUrl, Date startDate) {
    if (!pageUrl) {
      return [] as Date[]
    }
    GPathResult result
    DateParser dateParser = new DateParser()
    Date[] res = withUrlReader(pageUrl.toURL() as URL) {
      result = new XmlSlurper(new Parser()).parseText(it.text)
      getPostsDates(result).collect { String date ->
        dateParser.parse(date).with {
          first().getDates().first()
        }
      }.findAll { it >= startDate } as Date[]
    }
    if (res.size() != 0 && res.last() > startDate) {
      def nPage = nextPage(result)
      println "Going to: ${nPage}"
      res += fetchData(nPage, startDate)
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