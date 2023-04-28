package ir.sso.client.keycloak;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;

@Component
public class CustomJwtDecoder implements JwtDecoder {

    @Override
    public Jwt decode(String token) throws JwtException {
        return getJwt(token);
    }

    public static Jwt getJwt(String token) {
        Jwt result = null;
        JwtDecoder jdLocal = JwtDecoders.fromIssuerLocation("http://localhost:9292/auth/realms/sso");
        JwtDecoder jdDomain = JwtDecoders.fromIssuerLocation("http://www.keycloak.org:9292/auth/realms/sso");
        JwtDecoder jdIp = JwtDecoders.fromIssuerLocation("http://127.0.0.1:9292/auth/realms/sso");
        try {
            result = jdLocal.decode(token);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            result = jdDomain.decode(token);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            result = jdIp.decode(token);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (result != null)
            System.out.println(result);
        return result;
    }
}
