import pragmatico.social.scrapers.Facebook
import pragmatico.social.scrapers.Twittr

// Place your Spring DSL code here
beans = {
  def fbToken = System.getenv('PRGM_FB_TOKEN')
  def twCKey = System.getenv('PRGM_TW_CKEY')
  def twCSec = System.getenv('PRGM_TW_CSEC')
  def twATok = System.getenv('PRGM_TW_ATOK')
  def twTSec = System.getenv('PRGM_TW_TSEC')

  facebook Facebook, fbToken
  twittr Twittr, twCKey, twCSec, twATok, twTSec
}
