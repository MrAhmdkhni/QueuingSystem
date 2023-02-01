package ir.rabin_andisheh.setmeetingtime.repository;

import ir.rabin_andisheh.setmeetingtime.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByUsername(String username);

}
