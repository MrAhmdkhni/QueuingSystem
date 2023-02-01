package ir.rabin_andisheh.setmeetingtime.repository;

import ir.rabin_andisheh.setmeetingtime.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
