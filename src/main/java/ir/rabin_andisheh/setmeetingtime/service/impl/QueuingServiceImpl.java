package ir.rabin_andisheh.setmeetingtime.service.impl;

import ir.rabin_andisheh.setmeetingtime.base.service.impl.BaseServiceImpl;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import ir.rabin_andisheh.setmeetingtime.repository.QueuingRepository;
import ir.rabin_andisheh.setmeetingtime.service.QueuingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueuingServiceImpl extends BaseServiceImpl<Queuing, Long, QueuingRepository> implements QueuingService {

    public QueuingServiceImpl(QueuingRepository repository) {
        super(repository);
    }

    @Override
    public List<Queuing> findAllByVisitorIdAndCustomerIdIsNull(Long visitorId) {
        return repository.findAllByVisitorIdAndCustomerIdIsNull(visitorId);
    }

    @Override
    public List<Queuing> findAllByVisitorId(Long visitorId) {
        return repository.findAllByVisitorId(visitorId);
    }

    @Override
    public List<Queuing> findAllByVisitorIdAndCustomerIdIsNotNull(Long visitorId) {
        return repository.findAllByVisitorIdAndCustomerIdIsNotNull(visitorId);
    }

    @Override
    public int editCustomerId(Long queuingId, Long customerId) {
        return repository.editCustomerId(queuingId, customerId);
    }
}
