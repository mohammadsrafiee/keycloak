package ir.sso.client.keycloak;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ClientSecurityConfig extends WebSecurityConfigurerAdapter {

    public ClientSecurityConfig() {

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeHttpRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated();
        http.oauth2Login();
        http.oauth2ResourceServer(httpSecurity -> httpSecurity.jwt(
                jwtConfigurer -> jwtConfigurer.decoder(CustomJwtDecoder::getJwt)
        ));
        // @formatter:on
    }

}
