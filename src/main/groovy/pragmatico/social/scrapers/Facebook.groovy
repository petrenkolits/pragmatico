package pragmatico.social.scrapers

import com.restfb.Connection
import com.restfb.DefaultFacebookClient
import com.restfb.FacebookClient
import com.restfb.Parameter
import com.restfb.Version
import com.restfb.types.Post
import groovy.transform.CompileStatic
import rating.calculatators.FbEntity

@CompileStatic
class Facebook {
  private final FacebookClient fbClient

  Facebook(String token) {
    fbClient = new DefaultFacebookClient(token, Version.VERSION_2_5)
  }

  FbEntity[] getData(String pageName, Date startDate) {
    Connection<Post> conn = fbClient.fetchConnection("${pageName}/posts", Post.class,
      Parameter.with('fields', 'id,created_time,shares,reactions.limit(0).summary(1)'),
      Parameter.with('limit', 100),
      Parameter.with('since', startDate))
    conn.data.collect { Post p ->
      new FbEntity(id: p.id, createdAt: p.createdTime, shares: p.sharesCount, reactions: p.reactionsCount)
    } as FbEntity[]
  }
}
