package com.employeeproject.IT355PZVanjaCekic4835.controller;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Position;
import com.employeeproject.IT355PZVanjaCekic4835.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/position")
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping("/all")
    public ResponseEntity<List<Position>> getAllPositions() {
        return ResponseEntity.ok(positionService.getAllPositions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Position>> getPositionById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(positionService.getPositionById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        return ResponseEntity.ok(positionService.savePosition(position));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Position> updatePosition(@PathVariable("id") Integer id, @RequestBody Position position) {
        positionService.getPositionById(id);
        return ResponseEntity.ok(positionService.savePosition(position));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable("id") Integer id) {
        positionService.deletePosition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/monthly-salary")
    public ResponseEntity<Integer> getMonthlySalary(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(positionService.getMothlySalary(id));
    }
}


//package com.employeeproject.IT355PZVanjaCekic4835.controller;
//
//
//import com.employeeproject.IT355PZVanjaCekic4835.entity.Position;
//import com.employeeproject.IT355PZVanjaCekic4835.services.PositionService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/position")
//@AllArgsConstructor
//public class PositionController {
//
//    private final PositionService positionService;
//
////    @GetMapping("/positions")
////    public List<Position> getAllPositions() {
////        return positionService.getAllPositions();
////    }
//@GetMapping("/positions")
//public ResponseEntity<List<Position>> getAllPositions() {
//    return ResponseEntity.ok(positionService.getAllPositions());
//}
//
//
//    @GetMapping("/position/{id}")
//    public ResponseEntity<Optional<Position>> getPositionById (@PathVariable("id") Integer id){
//        return ResponseEntity.ok(positionService.getPositionById(id));
//    }
//
//    @PostMapping("/position")
//    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
//        return ResponseEntity.ok(positionService.savePosition(position));
//    }
//
//    @PutMapping("/position/{id}")
//    public ResponseEntity<Position> updatePosition(@PathVariable Integer id, @RequestBody Position position) {
//        positionService.getPositionById(id);
//    return ResponseEntity.ok(positionService.savePosition(position));
//    }
//
//    @DeleteMapping("/position/{id}")
//    public ResponseEntity<Void> deletePosition(@PathVariable Integer id) {
//        positionService.getPositionById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @GetMapping("/position/{id}")
//    public int getMonthlySalary(@PathVariable Integer id) {
//        return positionService.getMothlySalary(id);
//    }
////    @GetMapping("/positions")
////    public ResponseEntity<List<Position>> getAllPositions() {
////        List<Position> positions = positionService.getAllPositions();
////        return new ResponseEntity<>(positions, HttpStatus.OK);
////    }
////
////    @GetMapping("/position/{id}")
////    public ResponseEntity<Position> getPositionById(@PathVariable("id") Integer id) {
////        Position position = positionService.getPositionById(id).orElseThrow(() -> new IllegalArgumentException("Position not found"));
////        return new ResponseEntity<>(position, HttpStatus.OK);
////    }
////
////    @PostMapping("/position")
////    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
////        Position savedPosition = positionService.savePosition(position);
////        return new ResponseEntity<>(savedPosition, HttpStatus.CREATED);
////    }
////
////    @PutMapping("/position/{id}")
////    public ResponseEntity<Position> updatePosition(@PathVariable("id") Integer id, @RequestBody Position position) {
////        position.setPositionId(id);
////        Position updatedPosition = positionService.updatePosition(position);
////        return new ResponseEntity<>(updatedPosition, HttpStatus.OK);
////    }
////
////    @DeleteMapping("/position/{id}")
////    public ResponseEntity<?> deletePosition(@PathVariable("id") Integer id) {
////        positionService.deletePosition(id);
////        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////    }
//
////    @GetMapping
////    public List<Position> getAllPositions() {
////        return positionService.getAllPositions();
////    }
////
////    @GetMapping("/{posionId}")
////    public Optional<Position> getPositionById(@PathVariable Integer posionId) {
////        return positionService.getPositionById(posionId);
////    }
////
////    @PostMapping
////    public Position savePosition(@RequestBody Position position) {
////        return positionService.savePosition(position);
////    }
////
////    @PutMapping
////    public Position updatePosition(@RequestBody Position position) {
////        return positionService.updatePosition(position);
////    }
////
////    @DeleteMapping("/{id}")
////    public void deletePosition(@PathVariable Integer id) {
////        positionService.deletePosition(id);
////    }
////
////    @GetMapping("/{positionId}/monthly-salary")
////    public int getMonthlySalary(@PathVariable Integer positionId) {
////        return positionService.getMothlySalary(positionId);
////    }
//}
