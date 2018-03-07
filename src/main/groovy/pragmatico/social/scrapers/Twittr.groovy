package pragmatico.social.scrapers

import groovy.transform.CompileStatic
import pragmatico.calculatators.TwEntity
import twitter4j.Status
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

@CompileStatic
class Twittr {
  private final Twitter twitter

  Twittr(String key, String secret, String token, String tokenSecret) {
    ConfigurationBuilder cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(key)
      .setOAuthConsumerSecret(secret)
      .setOAuthAccessToken(token)
      .setOAuthAccessTokenSecret(tokenSecret)
    twitter = new TwitterFactory(cb.build()).getInstance()
  }

  TwEntity[] getData(String user, Date startDate) {
    if (!user) {
      return [] as TwEntity[]
    }
    List<Status> statuses = twitter.getUserTimeline(user)
    statuses.inject([]) { List<TwEntity> list, Status st ->
      if (st.createdAt > startDate) {
        list << new TwEntity(id: st.id as String, createdAt: st.createdAt, retweetCount: st.retweetCount, favoriteCount: st.favoriteCount)
      }
      list
    } as TwEntity[]
  }
}
