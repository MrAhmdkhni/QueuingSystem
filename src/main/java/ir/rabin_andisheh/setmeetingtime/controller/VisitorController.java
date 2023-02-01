package ir.rabin_andisheh.setmeetingtime.controller;

import ir.rabin_andisheh.setmeetingtime.dto.PersonDTO;
import ir.rabin_andisheh.setmeetingtime.dto.QueuingDTO;
import ir.rabin_andisheh.setmeetingtime.entity.Visitor;
import ir.rabin_andisheh.setmeetingtime.service.VisitorService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

    private final VisitorService visitorService;
    private final ModelMapper mapper;

    public VisitorController(VisitorService visitorService, ModelMapper mapper) {
        this.visitorService = visitorService;
        this.mapper = mapper;
    }

    @GetMapping("/viewAllQueuing")
    public List<QueuingDTO> viewAllQueuing(Authentication authentication) {
        Visitor authenticatedVisitor = (Visitor) authentication.getPrincipal();
        List<QueuingDTO> queuingDTOS = new ArrayList<>();
        visitorService.viewAllQueuing(authenticatedVisitor.getId()).forEach(
                queuing -> queuingDTOS.add(mapper.map(queuing, QueuingDTO.class))
        );
        return queuingDTOS;
    }

    @GetMapping("/viewAllReservedQueuing")
    public List<QueuingDTO> viewAllReservedQueuing(Authentication authentication) {
        Visitor authenticatedVisitor = (Visitor) authentication.getPrincipal();
        List<QueuingDTO> queuingDTOS = new ArrayList<>();
        visitorService.viewAllReservedQueuing(authenticatedVisitor.getId()).forEach(
                queuing -> queuingDTOS.add(mapper.map(queuing, QueuingDTO.class))
        );
        return queuingDTOS;
    }

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody PersonDTO personDTO) {
        visitorService.signup(
                Visitor.builder()
                        .firstname(personDTO.getFirstname())
                        .lastname(personDTO.getLastname())
                        .username(personDTO.getUsername())
                        .password(personDTO.getPassword())
                        .build()
        );
    }
}
