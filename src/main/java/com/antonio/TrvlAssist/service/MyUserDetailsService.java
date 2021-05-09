package  com.antonio.TrvlAssist.service;

import  com.antonio.TrvlAssist.model.MyUserDetails;
import  com.antonio.TrvlAssist.model.User;
import com.antonio.TrvlAssist.repository.UserRepository;
  
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.getUserByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

        return user.map(MyUserDetails::new).get();
    }
}
