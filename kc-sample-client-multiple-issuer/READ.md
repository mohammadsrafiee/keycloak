# Project Title <a name="title"></a>

`kc-client-multiple-issuers` is Multiple Issuers Token Authentication Support in Spring Boot application.

## Description <a name="description"></a>

This Java project, built using Spring Boot, aims to address the issue of multiple issuers in token authentication.
It provides a solution that allows for the validation and authentication of tokens from various issuers.
By supporting multiple issuers, this project enhances flexibility and security in token-based authentication systems.

## Features <a name="features"></a>

* **Multiple issuers support**: The project enables authentication and validation of tokens from multiple issuers,
  providing flexibility in handling various token sources.
* **Token-based authentication**: Leveraging token-based authentication,
  the project allows users to securely authenticate and authorize access to protected resources.
* **Integration with Spring Boot**: The project is built on the Spring Boot framework,
  providing a robust and scalable foundation for developing Java applications.

## Usage <a name="usage"></a>

To install and set up the project, follow these steps:

1. Clone the repository to your local machine.
2. Ensure that you have Java Development Kit (JDK) 8 or above installed.
3. Install and configure Apache Maven as the build tool.
4. Choose whether to use Docker for installing Keycloak or install it without Docker
   **(Consider that All guides are based on [Configuration](#configuration) section)**.
5. Navigate to the project directory and run the following command to build the project:
   `mvnw spring-boot:run` or `mvnw.cmdmvn spring-boot:run`
6. To view the endpoints of Keycloak, use  
   [http://www.keycloak.org:9292/auth/realms/sso/.well-known/openid-configuration.](http://www.keycloak.org:9292/auth/realms/sso/.well-known/openid-configuration)
7. Generate a token (this token should be sent with each request in the **Authorization** header)
   either by using Postman or calling
   the [http://localhost:8080/public/api/token/org](http://localhost:8080/public/api/token/org) (**org-domain-token**)
   and
   [http://localhost:8080/public/api/token/local](http://localhost:8080/public/api/token/local)
   (**localhost-domain-token**).
8. Open Postman and call the URL [http://localhost:8080/private/api/](http://localhost:8080/private/api/).
   Set the token generated (**localhost-domain-token**) in step 7 in the Authorization header of the request.
9. Call the URL [http://localhost:8080/private/api/](http://localhost:8080/private/api/).
   Again, set the token generated (**org-domain-token**) in step 7 in the Authorization header of the request.
10. Both requests will receive a successful HTTP response with a status code of 200.

_**Additionally, You can see test case of the project & use postman exported file at this project**_

## Configuration <a name="configuration"></a>

* Install a Keycloak with below configuration or use _**docker-compose.yml**_ file.
    * master real username: _**admin**_
    * master real password: _**admin**_
    * keycloak host port : _**9292**_
    * create a new real with name _**sso**_
    * create a client in sso realm with name _**sample-client**_
    * sso realm username : **_bob_**
    * sso realm password : **_bob_**
* Add two domain into **_/etc/host_** **(linux)** or
  _**C:\Windows\System32\drivers\etc\host**_ **(windows)** file such as bellow command:
    * 127.0.0.1            www.keycloak.org
* project start over http port **_8080_**

## Contributing <a name="contributing"></a>

Contributions to this project are welcome! To contribute, follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with descriptive messages.
4. Push your changes to your forked repository.
5. Submit a pull request, explaining the purpose and changes of your contribution.

## License <a name="license"></a>

This project is released under the terms of the
[GNU General Public License (GPL)](https://www.gnu.org/licenses/gpl-3.0.en.html),
which is a free and open-source license.
You are free to use, modify, and distribute the project in compliance with the terms outlined in the GPL.

## Contact <a name="license"></a>

For any inquiries or feedback, please contact **Mohammad Sadegh Rafiee** at
**[mohammadsrafiee@gmail.com](mohammadsrafiee@gmail.com)**.
Feel free to customize the sections further according to your project's specific details and
requirements. Best of luck with your Java project!

## Reference Documentation <a name="license"></a>

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
