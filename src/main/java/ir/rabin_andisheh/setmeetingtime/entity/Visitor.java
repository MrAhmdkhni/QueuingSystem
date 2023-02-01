package ir.rabin_andisheh.setmeetingtime.entity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Visitor extends Person {

    @Builder
    public Visitor(String firstname, String lastname, String username, String password, Boolean enable, Role role) {
        super(firstname, lastname, username, password, enable, role);
    }
}
