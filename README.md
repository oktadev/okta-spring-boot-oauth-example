# Spring Boot, OAuth 2.0, and Okta Example

A Spring Boot example app that shows how to implement single sign-on (SSO) with Spring Security and Okta.

Please read [Get Started with Spring Boot, OAuth 2.0, and Okta](http://developer.okta.com/blog/2017/03/21/spring-boot-oauth) to see how this app was created.

**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage and secure users and roles in any application.

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/oktadeveloper/okta-spring-boot-oauth-example.git
cd okta-spring-boot-oauth-example
```

This will get a copy of the project installed locally. To install all of its dependencies and start the app, run:
 
```bash
./mvnw spring-boot:run
```

### Create an OIDC App in Okta

You will need to [create an OIDC App in Okta](https://developer.okta.com/blog/2017/03/21/spring-boot-oauth#create-an-openid-connect-app-in-okta) to get a `clientId` and `clientSecret`. 

Log in to your Okta Developer account (or [sign up](https://developer.okta.com/signup/) if you don’t have an account) and navigate to **Applications** > **Add Application**. Click **Web**, click **Next**, and give the app a name you’ll remember. Click **Done** and copy the `clientId` and `clientSecret` into `server/src/main/resources/application.yml`. 

```yaml
security:
  oauth2:
    client:
      # From OIDC app
      clientId: {clientId}
      clientSecret: {clientSecret}
      # From Authorization Server's metadata
      accessTokenUri: https://{yourOktaDomain}.com/oauth2/default/v1/token	
      userAuthorizationUri: https://{yourOktaDomain}.com/oauth2/default/v1/authorize 
      clientAuthenticationScheme: form
      scope: openid profile email
    resource:
      # from your Auth Server's metadata, check .well-known/openid-configuration if not in .well-known/oauth-authorization-server
      userInfoUri: https://{yourOktaDomain}.com/oauth2/default/v1/userinfo
```

**NOTE:** The value of `{yourOktaDomain}` should be something like `dev-123456.oktapreview`. Make sure you don't include `-admin` in the value!

After modifying this file, restart your app and you'll be redirect to Okta to login.

## Links

This example uses [Spring Security OAuth](http://projects.spring.io/spring-security-oauth/) to integrate with Okta.

## Help

Please post any questions as comments on the [blog post](https://developer.okta.com/blog/2017/03/21/spring-boot-oauth), or visit our [Okta Developer Forums](https://devforum.okta.com/). You can also email developers@okta.com if would like to create a support ticket.

## License

Apache 2.0, see [LICENSE](LICENSE).

