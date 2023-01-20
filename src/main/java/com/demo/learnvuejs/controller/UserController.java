package com.demo.learnvuejs.controller;

import com.demo.learnvuejs.entity.User;
import com.demo.learnvuejs.exception.NotFoundException;
import com.demo.learnvuejs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

}
