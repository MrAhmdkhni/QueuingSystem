package ir.rabin_andisheh.setmeetingtime.service;

import ir.rabin_andisheh.setmeetingtime.entity.Customer;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import ir.rabin_andisheh.setmeetingtime.entity.Visitor;

import java.util.List;

public interface AdminService {

    void visitorAppointmentTime(Long visitorId, Queuing queuing, Long duration);

    List<Visitor> viewAllVisitor();

    List<Customer> viewAllCustomer();
}
