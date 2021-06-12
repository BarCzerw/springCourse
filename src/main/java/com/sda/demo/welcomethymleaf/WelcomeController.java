package com.sda.demo.welcomethymleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcomePage(ModelMap modelMap) {
        modelMap.addAttribute("message", LocalDateTime.now());
        return "welcomeView";
    }

}
