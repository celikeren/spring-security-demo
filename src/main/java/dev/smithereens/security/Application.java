package dev.smithereens.security;

import dev.smithereens.security.entity.User;
import dev.smithereens.security.enums.Role;
import dev.smithereens.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class Application {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveUserAtStartup() {
        var user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("123"));
        user.setRole(Role.USER);
        userRepository.save(user);
    }
}
