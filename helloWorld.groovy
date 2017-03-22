@Grab('spring-boot-starter-security')
@RestController
class Application {

  @RequestMapping('/')
  String home() {
    'Hello World'
  }
}
