package ir.rabin_andisheh.setmeetingtime.service;

import ir.rabin_andisheh.setmeetingtime.base.service.BaseService;
import ir.rabin_andisheh.setmeetingtime.entity.Person;

import java.util.Optional;

public interface PersonService extends BaseService<Person, Long> {

    Optional<Person> findByUsername(String username);
}
