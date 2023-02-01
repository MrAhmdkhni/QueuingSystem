package ir.rabin_andisheh.setmeetingtime.service;

import ir.rabin_andisheh.setmeetingtime.base.service.BaseService;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;

import java.util.List;

public interface QueuingService extends BaseService<Queuing, Long> {

    List<Queuing> findAllByVisitorIdAndCustomerIdIsNull(Long visitorId);

    List<Queuing> findAllByVisitorId(Long visitorId);

    List<Queuing> findAllByVisitorIdAndCustomerIdIsNotNull(Long visitorId);

    int editCustomerId(Long queuingId, Long customerId);
}
