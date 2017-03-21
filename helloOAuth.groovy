@Grab('spring-boot-starter-security')
@RestController
@EnableOAuth2Sso
class Application {

  @GetMapping('/')
  String home(java.security.Principal user) {
    'Hello ' + user.name
  }
}
