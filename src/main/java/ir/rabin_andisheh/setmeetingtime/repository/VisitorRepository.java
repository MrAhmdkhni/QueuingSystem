package ir.rabin_andisheh.setmeetingtime.repository;

import ir.rabin_andisheh.setmeetingtime.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {
}
