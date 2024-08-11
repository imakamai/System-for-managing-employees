package com.employeeproject.IT355PZVanjaCekic4835.controller;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Leave;
import com.employeeproject.IT355PZVanjaCekic4835.services.LeaveService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leave")
@AllArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @GetMapping("/leaves")
    public ResponseEntity<List<Leave>> getAllLeaves() {
        return ResponseEntity.ok(leaveService.getAllLeaves());
    }

    @GetMapping("/leave/{id}")
    public ResponseEntity<Optional<Leave>> getLeaveById(@PathVariable Integer id) {
        return ResponseEntity.ok(leaveService.getLeaveById(id));
    }

    @PostMapping("/leave")
    public ResponseEntity<Leave> createLeave(@RequestBody Leave leave) {
        return ResponseEntity.ok(leaveService.saveLeave(leave));
    }

    @PutMapping("/leave/{id}")
    public ResponseEntity<Leave> updateLeave( @PathVariable Integer id, @RequestBody Leave leave) {
        leaveService.getLeaveById(id);
        return ResponseEntity.ok(leaveService.saveLeave(leave));
    }

    @DeleteMapping("/leave/{id}")
    public ResponseEntity<Leave> deleteLeave(@PathVariable Integer id) {
        leaveService.getLeaveById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/leave/{id}")
//    public ResponseEntity<Leave> getLeaveById(@PathVariable("id") Integer id) {
//        Leave leave = leaveService.getLeaveById(id).orElseThrow(() -> new IllegalArgumentException("Leave not found"));
//        return new ResponseEntity<>(leave, HttpStatus.OK);
//    }
//
//    @PostMapping("/leave")
//    public ResponseEntity<Leave> createLeave(@RequestBody Leave leave) {
//        Leave savedLeave = leaveService.saveLeave(leave);
//        return new ResponseEntity<>(savedLeave, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/leave/{id}")
//    public ResponseEntity<Leave> updateLeave(@PathVariable("id") Integer id, @RequestBody Leave leave) {
//        leave.setLeaveId(id);
//        Leave updatedLeave = leaveService.updateLeave(leave);
//        return new ResponseEntity<>(updatedLeave, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/leave/{id}")
//    public ResponseEntity<?> deleteLeave(@PathVariable("id") Integer id) {
//        leaveService.deleteLeave(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
