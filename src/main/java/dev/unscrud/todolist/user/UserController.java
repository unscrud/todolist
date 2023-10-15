package dev.unscrud.todolist.user;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private IUserRepository userRepository;

    @PostMapping
    public User create(@RequestBody User user) {
        return this.userRepository.save(user);
    }
    
}
