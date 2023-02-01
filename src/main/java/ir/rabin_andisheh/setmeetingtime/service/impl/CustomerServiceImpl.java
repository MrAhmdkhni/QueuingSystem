package ir.rabin_andisheh.setmeetingtime.service.impl;

import ir.rabin_andisheh.setmeetingtime.base.service.impl.BaseServiceImpl;
import ir.rabin_andisheh.setmeetingtime.entity.Customer;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import ir.rabin_andisheh.setmeetingtime.entity.Role;
import ir.rabin_andisheh.setmeetingtime.exception.DuplicateUsernameException;
import ir.rabin_andisheh.setmeetingtime.exception.QueuingNotFoundException;
import ir.rabin_andisheh.setmeetingtime.repository.CustomerRepository;
import ir.rabin_andisheh.setmeetingtime.service.CustomerService;
import ir.rabin_andisheh.setmeetingtime.service.PersonService;
import ir.rabin_andisheh.setmeetingtime.service.QueuingService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository> implements CustomerService {

    private final QueuingService queuingService;
    private final PersonService personService;
    private final BCryptPasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerRepository repository, QueuingService queuingService, PersonService personService, BCryptPasswordEncoder passwordEncoder) {
        super(repository);
        this.queuingService = queuingService;
        this.personService = personService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Queuing> viewAllQueuing() {
        List<Queuing> queuings = queuingService.findAll();
        if (queuings.isEmpty())
            throw new QueuingNotFoundException("there is no queuing!");
        return queuings;
    }

    @Override
    public List<Queuing> viewAllQueuingByVisitorId(Long visitorId) {
        List<Queuing> queuings = queuingService.findAllByVisitorIdAndCustomerIdIsNull(visitorId);
        if (queuings.isEmpty())
            throw new QueuingNotFoundException("there is no queuing!");
        return queuings;
    }

    @Override
    @Transactional
    public void selectQueuing(Long queuingId, Long customerId) {
        int affectedRows = queuingService.editCustomerId(queuingId, customerId);
        if (affectedRows == 0)
            throw new QueuingNotFoundException("there is no queuing!");
    }

    @Override
    public void signup(Customer customer) {
        if (personService.findByUsername(customer.getUsername()).isPresent())
            throw new DuplicateUsernameException("this username already exist!");
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole(Role.ROLE_CUSTOMER);
        customer.setEnable(true);
        saveOrUpdate(customer);
    }
}
