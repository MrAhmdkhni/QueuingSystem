package ir.rabin_andisheh.setmeetingtime.service;

import ir.rabin_andisheh.setmeetingtime.base.service.BaseService;
import ir.rabin_andisheh.setmeetingtime.entity.Customer;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;

import java.util.List;

public interface CustomerService extends BaseService<Customer, Long> {

    List<Queuing> viewAllQueuing();

    List<Queuing> viewAllQueuingByVisitorId(Long visitorId);

    void selectQueuing(Long queuingId, Long customerId);

    void signup(Customer customer);
}
