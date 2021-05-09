package  com.antonio.TrvlAssist.repository;

import  com.antonio.TrvlAssist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUsername(String username);

    User getById(Long id);
}
