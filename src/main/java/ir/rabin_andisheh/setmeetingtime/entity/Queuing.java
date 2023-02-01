package ir.rabin_andisheh.setmeetingtime.entity;

import ir.rabin_andisheh.setmeetingtime.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Queuing extends BaseEntity<Long> {

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime visitTime;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Visitor visitor;

    @Builder
    public Queuing(LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Queuing(LocalDate date, LocalTime startTime, LocalTime endTime, LocalTime visitTime, Visitor visitor) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.visitTime = visitTime;
        this.visitor = visitor;
    }
}
