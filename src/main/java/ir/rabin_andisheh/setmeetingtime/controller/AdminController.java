package ir.rabin_andisheh.setmeetingtime.controller;

import ir.rabin_andisheh.setmeetingtime.dto.VisitorQueuingDTO;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import ir.rabin_andisheh.setmeetingtime.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
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
}
