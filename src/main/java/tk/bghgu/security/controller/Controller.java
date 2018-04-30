package tk.bghgu.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ds on 2018-04-30.
 */

@RestController
public class Controller {

    @GetMapping("login")
    public String login() {
        return "LOGIN PAGE";
    }

    @PostMapping("login")
    public String loginProcessing() {
        return "1";
    }

    /**
     * forward
     * @return
     */
    @GetMapping("home")
    public String home() {
        return "forward:/login";
    }


    @GetMapping("admin")
    public String admin() {
        return "LOGIN SUCCESS";
    }
}
