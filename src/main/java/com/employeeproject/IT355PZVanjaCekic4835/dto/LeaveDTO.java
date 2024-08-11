package com.employeeproject.IT355PZVanjaCekic4835.dto;

import com.employeeproject.IT355PZVanjaCekic4835.enums.LeaveType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveDTO {
    private Integer leaveId;
    private LeaveType leaveType;

    public LeaveDTO() {
    }

    public LeaveDTO(Integer leaveId, LeaveType leaveType) {
        this.leaveId = leaveId;
        this.leaveType = leaveType;
    }
}
