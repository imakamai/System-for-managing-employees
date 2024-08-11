package com.employeeproject.IT355PZVanjaCekic4835.services.impl;

import com.employeeproject.IT355PZVanjaCekic4835.entity.EmployeePosition;
import com.employeeproject.IT355PZVanjaCekic4835.repository.EmployeePositionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeePositionServiceImplTest {

    @Mock
    private EmployeePositionRepository employeePositionRepository;

    @InjectMocks
    private EmployeePositionServiceImpl employeePositionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllEmployeePositions() {

        List<EmployeePosition> mockPositions = Arrays.asList(
                new EmployeePosition(1, null, null),
                new EmployeePosition(2, null, null)
        );
        when(employeePositionRepository.findAll()).thenReturn(mockPositions);


        List<EmployeePosition> positions = employeePositionService.getAllEmployeePositions();


        assertNotNull(positions);
        assertEquals(2, positions.size());
        verify(employeePositionRepository, times(1)).findAll();
    }

    @Test
    void getEmployeePositionById() {

        EmployeePosition mockPosition = new EmployeePosition(1, null, null);
        when(employeePositionRepository.findById(1)).thenReturn(Optional.of(mockPosition));


        Optional<EmployeePosition> position = employeePositionService.getEmployeePositionById(1);


        assertTrue(position.isPresent());
        assertEquals(1, position.get().getEmployeePositionId());
        verify(employeePositionRepository, times(1)).findById(1);
    }
}