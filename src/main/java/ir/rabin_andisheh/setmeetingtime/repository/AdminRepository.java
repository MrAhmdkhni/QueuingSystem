package ir.rabin_andisheh.setmeetingtime.repository;

import ir.rabin_andisheh.setmeetingtime.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
