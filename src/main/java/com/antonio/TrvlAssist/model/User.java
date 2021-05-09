package  com.antonio.TrvlAssist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean active;
    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Role role;
    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Gender gender;


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {

        return firstName + " " + lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public Role getRole() {
        return role;
    }

    public Gender getGender() {
        return gender;
    }


   


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    


    @Override
    public String toString() {

        return "User " + id + " : [name = " + firstName + " " + lastName + ", username = " + username +
               ", password = " + password + ", active = " + active + ", gender = " + gender + ", role = " + role + "]";
    }

    public enum Gender {

        MALE("Male"), FEMALE("Female");

        private final String value;

        Gender(String value) {

            this.value = value;
        }

        public String toString() {

            return value;
        }
    }

    public enum Role {

        ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

        private final String value;

        Role(String value) {

            this.value = value;
        }

        public String toString() {

            return value;
        }
    }
}
