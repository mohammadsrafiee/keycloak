package ir.sso.client.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GeneralController.BASIC_PREFIX_URL)
public class GeneralController {
    public static final String BASIC_PREFIX_URL = "/private/api";
    public static final String HOME_URL = "/";

    @RequestMapping(path = HOME_URL, method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> home() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}