package  com.antonio.TrvlAssist.model.form;

import  com.antonio.TrvlAssist.model.User;
import lombok.*;

import static  com.antonio.TrvlAssist.model.User.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EditUserProfileForm {

    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private Gender gender;

    public EditUserProfileForm(User user) {

        userId = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        username = user.getUsername();
        gender = user.getGender();
    }
}
