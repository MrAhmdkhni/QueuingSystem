package ir.rabin_andisheh.setmeetingtime.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueuingDTO {

    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime visitTime;
    private String visitor;
}
