package pragmatico

class SampleJob {
  static triggers = {
//    simple repeatInterval: 5000l // execute job once in 5 seconds
//    simple repeatCount: 1
  }

  def execute(context) {
    println 'sample job start'
    println context.mergedJobDataMap
    sleep(5000)
    println 'sample job end'
  }
}
