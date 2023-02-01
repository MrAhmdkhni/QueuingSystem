package ir.rabin_andisheh.setmeetingtime.service.impl;

import ir.rabin_andisheh.setmeetingtime.base.service.impl.BaseServiceImpl;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import ir.rabin_andisheh.setmeetingtime.entity.Role;
import ir.rabin_andisheh.setmeetingtime.entity.Visitor;
import ir.rabin_andisheh.setmeetingtime.exception.DuplicateUsernameException;
import ir.rabin_andisheh.setmeetingtime.exception.QueuingNotFoundException;
import ir.rabin_andisheh.setmeetingtime.repository.VisitorRepository;
import ir.rabin_andisheh.setmeetingtime.service.PersonService;
import ir.rabin_andisheh.setmeetingtime.service.QueuingService;
import ir.rabin_andisheh.setmeetingtime.service.VisitorService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorServiceImpl extends BaseServiceImpl<Visitor, Long, VisitorRepository> implements VisitorService {

    private final QueuingService queuingService;
    private final PersonService personService;
    private final BCryptPasswordEncoder passwordEncoder;

    public VisitorServiceImpl(VisitorRepository repository, QueuingService queuingService, PersonService personService, BCryptPasswordEncoder passwordEncoder) {
        super(repository);
        this.queuingService = queuingService;
        this.personService = personService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Queuing> viewAllQueuing(Long visitorId) {
        List<Queuing> queuings = queuingService.findAllByVisitorId(visitorId);
        if (queuings.isEmpty())
            throw new QueuingNotFoundException("there is no queuing!");
        return queuings;
    }

    @Override
    public List<Queuing> viewAllReservedQueuing(Long visitorId) {
        List<Queuing> queuings = queuingService.findAllByVisitorIdAndCustomerIdIsNotNull(visitorId);
        if (queuings.isEmpty())
            throw new QueuingNotFoundException("there is no queuing!");
        return queuings;
    }

    @Override
    public void signup(Visitor visitor) {
        if (personService.findByUsername(visitor.getUsername()).isPresent())
            throw new DuplicateUsernameException("this username already exist!");
        visitor.setPassword(passwordEncoder.encode(visitor.getPassword()));
        visitor.setRole(Role.ROLE_VISITOR);
        visitor.setEnable(true);
        saveOrUpdate(visitor);
    }
}
