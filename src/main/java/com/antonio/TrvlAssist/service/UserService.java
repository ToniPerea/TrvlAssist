package  com.antonio.TrvlAssist.service;

import  com.antonio.TrvlAssist.model.*;
    
   
import com.antonio.TrvlAssist.repository.UserRepository;
 
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


import static  com.antonio.TrvlAssist.model.User.Role.USER;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    public void registerUser(User user) {

        user.setActive(true);
        user.setRole(USER);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getAuthenticatedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> optionalUser = userRepository.getUserByUsername(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return optionalUser.get();
    }

    public boolean isNewUser(String username) {

        return !userRepository.findAll().stream()
                .map(User::getUsername)
                .collect(Collectors.toList())
                .contains(username);
    }

    public User getUserByID(Long id) {

        return userRepository.getById(id);
    }



}