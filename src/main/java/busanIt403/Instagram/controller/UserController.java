package busanIt403.Instagram.controller;

import busanIt403.Instagram.model.UserModel;
import busanIt403.Instagram.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log
@Controller
@RequestMapping("account")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/login")
    public String login () {

        return "/account/login";
    }

    @RequestMapping("/register")
    public String register(){

        return "/account/register";
    }

    @RequestMapping("/success")
    public String success(){

        return "/account/success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(UserModel userModel){
        log.info("userModel == " + userModel);

        userModel.setRole("ROLE_ADMIN");
        String rowPassword = userModel.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rowPassword);
        userModel.setPassword(encPassword);

        userService.register(userModel);

        return "/account/login";
    }

}
