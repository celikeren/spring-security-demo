package dev.smithereens.security.data;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserProvider {

    private final static List<UserDetails> USERS =
            Arrays.asList(
                    new User("admin@mail.com",
                            "123456",
                            Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
                    ),
                    new User("user@mail.com",
                            "password",
                            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
                    )
            );


    public UserDetails findUserByEmail(String email) {
        return USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
