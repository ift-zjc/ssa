package com.ift.web.controller;

import com.ift.domain.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by chen3 on 4/4/17.
 */

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public User greeting(User message) throws Exception {
        Thread.sleep(1000); // simulated delay
        User user = new User();
        user.setLastname(message.getLastname());
        return user;
    }


    @GetMapping(value = "/index")
    public String showIndex(Model model){
        return "index";
    }
}
