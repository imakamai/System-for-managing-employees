package com.employeeproject.IT355PZVanjaCekic4835.dto;

import com.employeeproject.IT355PZVanjaCekic4835.enums.PositionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionDTO {
    private Integer positionId;
    private PositionType positionType;
    private Integer mothlyWorkingHours;
    private Integer salaryPerHour;

    public PositionDTO() {
    }

    public PositionDTO(Integer positionId, PositionType positionType, Integer mothlyWorkingHours, Integer salaryPerHour) {
        this.positionId = positionId;
        this.positionType = positionType;
        this.mothlyWorkingHours = mothlyWorkingHours;
        this.salaryPerHour = salaryPerHour;
    }

}
