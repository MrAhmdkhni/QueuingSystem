package ir.rabin_andisheh.setmeetingtime.controller;

import ir.rabin_andisheh.setmeetingtime.dto.PersonsDTO;
import ir.rabin_andisheh.setmeetingtime.dto.VisitorQueuingDTO;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import ir.rabin_andisheh.setmeetingtime.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final ModelMapper mapper;

    public AdminController(AdminService adminService, ModelMapper mapper) {
        this.adminService = adminService;
        this.mapper = mapper;
    }

    @PostMapping("/visitorAppointmentTime")
    public void visitorAppointmentTime(@RequestBody VisitorQueuingDTO visitorQueuingDTO) {
        adminService.visitorAppointmentTime(
                visitorQueuingDTO.getVisitorId(),
                Queuing.builder()
                        .date(LocalDate.parse(visitorQueuingDTO.getDate()))
                        .startTime(LocalTime.parse(visitorQueuingDTO.getStartTime()))
                        .endTime(LocalTime.parse(visitorQueuingDTO.getEndTime()))
                        .build(),
                visitorQueuingDTO.getDurationTime()
        );
    }

    @GetMapping("/viewAllVisitor")
    public List<PersonsDTO> viewAllVisitor() {
        List<PersonsDTO> personsDTOS = new ArrayList<>();
        adminService.viewAllVisitor().forEach(
                visitor -> personsDTOS.add(mapper.map(visitor, PersonsDTO.class))
        );
        return personsDTOS;
    }

    @GetMapping("/viewAllCustomer")
    public List<PersonsDTO> viewAllCustomer() {
        List<PersonsDTO> personsDTOS = new ArrayList<>();
        adminService.viewAllCustomer().forEach(
                visitor -> personsDTOS.add(mapper.map(visitor, PersonsDTO.class))
        );
        return personsDTOS;
    }
}
