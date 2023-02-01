package ir.rabin_andisheh.setmeetingtime.service.impl;

import ir.rabin_andisheh.setmeetingtime.base.service.impl.BaseServiceImpl;
import ir.rabin_andisheh.setmeetingtime.entity.Admin;
import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import ir.rabin_andisheh.setmeetingtime.entity.Visitor;
import ir.rabin_andisheh.setmeetingtime.exception.VisitorNotFoundException;
import ir.rabin_andisheh.setmeetingtime.repository.AdminRepository;
import ir.rabin_andisheh.setmeetingtime.service.AdminService;
import ir.rabin_andisheh.setmeetingtime.service.QueuingService;
import ir.rabin_andisheh.setmeetingtime.service.VisitorService;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepository> implements AdminService {

    private final VisitorService visitorService;
    private final QueuingService queuingService;

    public AdminServiceImpl(AdminRepository repository, VisitorService visitorService, QueuingService queuingService) {
        super(repository);
        this.visitorService = visitorService;
        this.queuingService = queuingService;
    }

    @Override
    public void visitorAppointmentTime(Long visitorId, Queuing queuing, Long duration) {
        Optional<Visitor> visitor = visitorService.findById(visitorId);
        if (visitor.isEmpty())
            throw new VisitorNotFoundException("there is no visitor!");
        long timeDifference = ChronoUnit.MINUTES.between(queuing.getStartTime(), queuing.getEndTime());
        long capacity = timeDifference / duration;
        for (long i = 0; i < capacity; i++) {
            Queuing newQueuing = new Queuing(
                    queuing.getDate(),
                    queuing.getStartTime(),
                    queuing.getEndTime(),
                    queuing.getStartTime().plusMinutes(duration * i),
                    visitor.get()
            );
            queuingService.saveOrUpdate(newQueuing);
        }
    }
}
