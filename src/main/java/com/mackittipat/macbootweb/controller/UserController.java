package com.mackittipat.macbootweb.controller;

import com.mackittipat.macbootweb.domain.User;
import com.mackittipat.macbootweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

}
