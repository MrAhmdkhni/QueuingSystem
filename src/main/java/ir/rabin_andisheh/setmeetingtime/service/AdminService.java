package ir.rabin_andisheh.setmeetingtime.service;

import ir.rabin_andisheh.setmeetingtime.entity.Queuing;

public interface AdminService {

    void visitorAppointmentTime(Long visitorId, Queuing queuing, Long duration);
}
