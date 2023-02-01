package ir.rabin_andisheh.setmeetingtime.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VisitorQueuingDTO {

    private Long visitorId;
    private String date;
    private String startTime;
    private String endTime;
    private Long durationTime;
}
