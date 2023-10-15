package dev.unscrud.todolist.user;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private IUserRepository userRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody User user) {
        var storedUser = this.userRepository.findByUsername(user.getUsername());

        if(storedUser != null){
            String msg = "Usuário já existe";
            logger.info(msg);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
        }

        String passwordHashed = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(passwordHashed);

        User newUser = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
}
