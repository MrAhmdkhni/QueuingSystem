package ir.rabin_andisheh.setmeetingtime.service;

import ir.rabin_andisheh.setmeetingtime.base.service.BaseService;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import ir.rabin_andisheh.setmeetingtime.entity.Visitor;

import java.util.List;

public interface VisitorService extends BaseService<Visitor, Long> {

    List<Queuing> viewAllQueuing(Long visitorId);

    List<Queuing> viewAllReservedQueuing(Long visitorId);

    void signup(Visitor visitor);
}
