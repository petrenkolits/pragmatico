package pragmatico.social.scrapers

import groovy.transform.CompileStatic
import twitter4j.Status
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder

@CompileStatic
class Twittr {
  private final Twitter twitter

  Twittr(String key, String secret, String token, String tokenSecret) {
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(key)
      .setOAuthConsumerSecret(secret)
      .setOAuthAccessToken(token)
      .setOAuthAccessTokenSecret(tokenSecret)
    twitter = new TwitterFactory(cb.build()).getInstance()
  }

  List<?> getData(String user) {
    List<Status> statuses = twitter.getUserTimeline(user)
    statuses.collect { Status st ->
      [id: st.id, test: st.text, createdAt: st.createdAt, retweetCount: st.retweetCount, favoriteCount: st.favoriteCount]
    }
  }
}
