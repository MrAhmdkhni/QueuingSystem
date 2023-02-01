package ir.rabin_andisheh.setmeetingtime.dto;

import ir.rabin_andisheh.setmeetingtime.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonsDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private Boolean enable;
    private Role role;
}
