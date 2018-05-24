@Grab('spring-boot-starter-security')
@Grab('org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure:2.0.1.RELEASE')

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso

@RestController
@EnableOAuth2Sso
class Application {

  @GetMapping('/')
  String home(java.security.Principal user) {
    'Hello ' + user.name
  }
}
