package pragmatico

//import groovy.transform.EqualsAndHashCode
//import groovy.transform.ToString
//import grails.compiler.GrailsCompileStatic
import org.bson.types.ObjectId
//import grails.config.Config
//import grails.core.support.GrailsConfigurationAware
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
//import groovy.transform.CompileDynamic
//import groovy.transform.CompileStatic

//@GrailsCompileStatic
//@EqualsAndHashCode(includes = 'id')
//@ToString(includes = 'facebook_responce', includeNames = true, includePackage = false)
class Facebook implements Serializable {
  ObjectId id
  String facebook_responce

}

//package org.openweathermap
//
//import grails.config.Config
//import grails.core.support.GrailsConfigurationAware
//import grails.plugins.rest.client.RestBuilder
//import grails.plugins.rest.client.RestResponse
//import groovy.transform.CompileDynamic
//import groovy.transform.CompileStatic
//
//@CompileStatic
//class OpenweathermapService implements GrailsConfigurationAware {
//    String appid
//    String cityName
//    String countryCode
//    String openWeatherUrl
//
//    @Override
//    void setConfiguration(Config co) {
//        openWeatherUrl = co.getProperty('openweather.url', String, 'http://api.openweathermap.org')
//        appid = co.getProperty('openweather.appid', String)
//        cityName = co.getProperty('openweather.cityName', String)
//        countryCode = co.getProperty('openweather.countryCode', String)
//    }
//    @CompileDynamic
//    CurrentWeather currentWeather(Unit units = Unit.Standard) {
//        currentWeather(cityName, countryCode, units)
//    }
//
//
//    @CompileDynamic
//    CurrentWeather currentWeather(String cityName, String countryCode, Unit unit = Unit.Standard) {
//        RestBuilder rest = new RestBuilder()
//        String url = "${openWeatherUrl}/data/2.5/weather?q={city},{countryCode}&appid={appid}"
//        Map params = [city: cityName, countryCode: countryCode, appid: appid]
//        String unitParam = unitParameter(unit)
//        if ( unitParam ) {
//            params.units = unitParam
//            url += "&units={units}"
//        }
//        RestResponse restResponse = rest.get(url) {
//            urlVariables params
//        }
//
//        if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
//            return OpenweathermapParser.currentWeatherFromJSONElement(restResponse.json)
//        }
//        null
//    }
//
//    /**
//     * @return null if Standard Unit
//     */
//    String unitParameter(Unit unit)  {
//        switch ( unit ) {
//            case Unit.Metric:
//                return 'metric'
//            case Unit.Imperial:
//                return 'imperial'
//            default:
//                return null
//        }
//    }
//}