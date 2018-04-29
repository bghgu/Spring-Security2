package tk.bghgu.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("home")
    public String home() {
        return "LOGIN SUCCESS";
    }
}
