package ir.rabin_andisheh.setmeetingtime.repository;

import ir.rabin_andisheh.setmeetingtime.entity.Queuing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueuingRepository extends JpaRepository<Queuing, Long> {

    @Query("""
            select q from Queuing q
            where q.visitor.id = :visitorId and q.customer.id is null
            """)
    List<Queuing> findAllByVisitorIdAndCustomerIdIsNull(Long visitorId);

    List<Queuing> findAllByVisitorId(Long visitorId);

    @Query("""
            select q from Queuing q
            where q.visitor.id = :visitorId and q.customer.id is not null
            """)
    List<Queuing> findAllByVisitorIdAndCustomerIdIsNotNull(Long visitorId);

    @Modifying
    @Query("""
            update Queuing q
            set q.customer.id = :customerId
            where q.id = :queuingId
            """)
    int editCustomerId(Long queuingId, Long customerId);
}
