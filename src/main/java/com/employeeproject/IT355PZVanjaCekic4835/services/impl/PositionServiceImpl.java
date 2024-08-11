package com.employeeproject.IT355PZVanjaCekic4835.services.impl;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Position;
import com.employeeproject.IT355PZVanjaCekic4835.repository.PositionRepository;
import com.employeeproject.IT355PZVanjaCekic4835.services.PositionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {

    private  final PositionRepository positionRepository;

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<Position> getPositionById(Integer positionId) {
        return positionRepository.findById(positionId);
    }

    @Override
    public Position savePosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public Position updatePosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    @Transactional
    public void deletePosition(Integer positionId) {
        positionRepository.deleteById(positionId);
    }

    @Override
    public int getMothlySalary(Integer positionId) {
        Optional<Position> positionOpt = positionRepository.findById(positionId);
        if (positionOpt.isPresent()) {
            Position position = positionOpt.get();
            return position.getMothlyWorkingHours() * position.getSalaryPerHour();
        } else {
            throw new IllegalArgumentException("Position not found for id: " + positionId);
        }
    }
}



