package busanIt403.Instagram.controller;

import busanIt403.Instagram.model.UserModel;
import busanIt403.Instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
//
    @RequestMapping("/")
    public String index(Model model){

        return "index";
    }
}
