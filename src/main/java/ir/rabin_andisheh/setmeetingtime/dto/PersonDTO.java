package ir.rabin_andisheh.setmeetingtime.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {

    private String firstname;
    private String lastname;
    private String username;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8}$",
            message = "the password must contain numbers, lowercase and uppercase letters")
    private String password;
}
