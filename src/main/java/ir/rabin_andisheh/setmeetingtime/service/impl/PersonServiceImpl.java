package ir.rabin_andisheh.setmeetingtime.service.impl;

import ir.rabin_andisheh.setmeetingtime.base.service.impl.BaseServiceImpl;
import ir.rabin_andisheh.setmeetingtime.entity.Person;
import ir.rabin_andisheh.setmeetingtime.repository.PersonRepository;
import ir.rabin_andisheh.setmeetingtime.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl extends BaseServiceImpl<Person, Long, PersonRepository> implements PersonService {

    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        try {
            return repository.findByUsername(username);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
