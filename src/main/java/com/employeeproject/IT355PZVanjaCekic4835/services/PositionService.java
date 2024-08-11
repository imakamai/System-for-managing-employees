package com.employeeproject.IT355PZVanjaCekic4835.services;


import com.employeeproject.IT355PZVanjaCekic4835.entity.Position;
import com.employeeproject.IT355PZVanjaCekic4835.enums.PositionType;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    List<Position> getAllPositions();

    Optional<Position> getPositionById(Integer positionId);

    Position savePosition(Position position);

    Position updatePosition(Position position);

    void deletePosition(Integer positionId);

    int getMothlySalary(Integer positionId);

}
