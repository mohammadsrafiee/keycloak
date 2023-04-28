package ir.sso.client.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(TokenController.BASIC_PREFIX_URL)
public class TokenController {

    public static final String BASIC_PREFIX_URL = "/public/api";
    public static final String TOKEN_LOCAL_URL = "/token/org";
    public static final String TOKEN_ORG_URL = "/token/local";

    private static final String REALM = "sso";
    private static final String USERNAME = "bob";
    private static final String PASSWORD = "bob";
    private static final String CLIENT_ID = "sample-client";
    private static final String URL_ORG = "http://www.keycloak.org:9292";
    private static final String URL_LOCAL = "http://localhost:9292";


    private final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(path = TOKEN_LOCAL_URL, method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> generateTokenByOrgDomain() {
        HttpEntity<String> request = new HttpEntity<>(createBody(), createHeader());
        return
                restTemplate.exchange(
                        createURI(URL_ORG),
                        HttpMethod.POST,
                        request,
                        String.class);
    }

    @RequestMapping(path = TOKEN_ORG_URL, method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> generateTokenByLocalDomain() {
        HttpEntity<String> request = new HttpEntity<>(createBody(), createHeader());
        return
                restTemplate.exchange(
                        createURI(URL_LOCAL),
                        HttpMethod.POST,
                        request,
                        String.class);
    }

    private String createBody() {
        StringBuffer body = new StringBuffer();
        body.append("grant_type");
        body.append("=");
        body.append("password");
        body.append("&");
        body.append("client_id");
        body.append("=");
        body.append(CLIENT_ID);
        body.append("&");
        body.append("username");
        body.append("=");
        body.append(USERNAME);
        body.append("&");
        body.append("password");
        body.append("=");
        body.append(PASSWORD);
        return body.toString();
    }

    private HttpHeaders createHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }

    private String createURI(String url) {
        return url + "/auth/realms/" + REALM + "/protocol/openid-connect/token";
    }
}
