package ir.rabin_andisheh.setmeetingtime.controller;

import ir.rabin_andisheh.setmeetingtime.dto.PersonDTO;
import ir.rabin_andisheh.setmeetingtime.dto.QueuingDTO;
import ir.rabin_andisheh.setmeetingtime.entity.Customer;
import ir.rabin_andisheh.setmeetingtime.service.CustomerService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper mapper;

    public CustomerController(CustomerService customerService, ModelMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @GetMapping("/viewAllQueuing")
    public List<QueuingDTO> viewAllQueuing() {
        List<QueuingDTO> queuingDTOS = new ArrayList<>();
        customerService.viewAllQueuing().forEach(
                queuing -> queuingDTOS.add(mapper.map(queuing, QueuingDTO.class))
                );
        return queuingDTOS;
    }

    @GetMapping("/viewAllQueuing/{visitorId}")
    public List<QueuingDTO> viewAllQueuingByVisitorId(@PathVariable Long visitorId) {
        List<QueuingDTO> queuingDTOS = new ArrayList<>();
        customerService.viewAllQueuingByVisitorId(visitorId).forEach(
                queuing -> queuingDTOS.add(mapper.map(queuing, QueuingDTO.class))
        );
        return queuingDTOS;
    }

    @PutMapping("/selectQueuing/{queuingId}")
    public void selectQueuing(@PathVariable Long queuingId, Authentication authentication) {
        Customer authenticatedCustomer = (Customer) authentication.getPrincipal();
        customerService.selectQueuing(queuingId, authenticatedCustomer.getId());
    }

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody PersonDTO personDTO) {
        customerService.signup(
                Customer.builder()
                        .firstname(personDTO.getFirstname())
                        .lastname(personDTO.getLastname())
                        .username(personDTO.getUsername())
                        .password(personDTO.getPassword())
                        .build()
        );
    }
}
