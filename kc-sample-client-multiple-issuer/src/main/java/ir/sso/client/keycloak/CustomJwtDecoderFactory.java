package ir.sso.client.keycloak;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Component;

@Component
public class CustomJwtDecoderFactory implements JwtDecoderFactory<ClientRegistration> {
    @Override
    public JwtDecoder createDecoder(ClientRegistration context) {
        return CustomJwtDecoder::getJwt;
    }
}
