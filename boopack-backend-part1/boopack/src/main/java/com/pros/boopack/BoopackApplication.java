package com.pros.boopack;

import com.pros.boopack.user.User;
import com.pros.boopack.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class BoopackApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BoopackApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String email1 = "pros@gmail.com";
        String password1 = "1234";

        Optional<User> optional = repository.findByEmail(email1);
        if (!optional.isPresent()) {
            User user = new User();
            user.setEmail(email1);
            user.setPassword(passwordEncoder().encode(password1));

            repository.save(user);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
