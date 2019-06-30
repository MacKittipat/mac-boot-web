package com.mackittipat.macbootweb.controller.web;

import com.mackittipat.macbootweb.domain.User;
import com.mackittipat.macbootweb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/create")
    public String createGet(@ModelAttribute User user) {
        return "user_create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute User user) {
        log.debug("Saving user : {}", user.toString());
        userRepository.save(user);
        return "user_create";
    }

    @GetMapping("/")
    public String list(Model model) {
        List<User> userList = (List<User>) userRepository.findAll();
        model.addAttribute("userList", userList);
        return "user_list";
    }
}
