package ir.rabin_andisheh.setmeetingtime.entity;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Customer extends Person {

    @Builder
    public Customer(String firstname, String lastname, String username, String password, Boolean enable, Role role) {
        super(firstname, lastname, username, password, enable, role);
    }
}
