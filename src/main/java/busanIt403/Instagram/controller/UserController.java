package busanIt403.Instagram.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
public class UserController {

    @RequestMapping("/login")
    public String login () {

        return "/user/login";
    }

}
