package com.employeeproject.IT355PZVanjaCekic4835.controller;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.LeaveRequire;
import com.employeeproject.IT355PZVanjaCekic4835.services.EmployeeService;
import com.employeeproject.IT355PZVanjaCekic4835.services.LeaveRequireService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leave_request")
@AllArgsConstructor
public class LeaveRequireController {
    private final LeaveRequireService leaveRequireService;
    private final EmployeeService employeeService;


    @GetMapping("/leave_requests")
    public ResponseEntity<List<LeaveRequire>> getAllLeaveRequests() {
        return ResponseEntity.ok(leaveRequireService.getAllLeaveRequire());
    }


    @GetMapping("/leave_request/{id}")
    public ResponseEntity<Optional<LeaveRequire>> getLeaveRequestById(@PathVariable Integer id) {;
        return ResponseEntity.ok(leaveRequireService.getLeaveRequireById(id));
    }


    @PostMapping("/leave_request")
    public ResponseEntity<LeaveRequire> createLeaveRequest(@RequestBody LeaveRequire leaveRequest) {
//        return new ResponseEntity<>(savedLeaveRequest, HttpStatus.CREATED);
        return  ResponseEntity.ok(leaveRequireService.saveLeaveRequest(leaveRequest));
    }
    @PutMapping("/leave_request/{id}/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LeaveRequire> approveLeaveRequest(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(leaveRequireService.approveLeaveRequest(id));
//        LeaveRequire leaveRequest = leaveRequireService.getLeaveRequireById(id).orElseThrow(() -> new IllegalArgumentException("Leave request not found"));
//
//        leaveRequest.setIsApproved(true);
//
////        LeaveRequire updatedLeaveRequest = leaveRequireService.saveLeaveRequest(leaveRequest);
////        return new ResponseEntity<>(updatedLeaveRequest, HttpStatus.OK);
//         return  ResponseEntity.ok(leaveRequireService.saveLeaveRequest(leaveRequest));
    }

    @GetMapping("/leave_request/my-requests")
    public ResponseEntity<List<LeaveRequire>> getMyLeaveRequests(Principal principal) {
        String email = principal.getName();
        Employee employee = employeeService.findByEmails(email);
        return ResponseEntity.ok(leaveRequireService.getLeaveRequestsByEmployee(employee));
}
//        String email = principal.getName();
//
//        Employee employee = employeeService.findByEmails(email)
//                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
//        List<LeaveRequire> leaveRequests = leaveRequireService.getAllLeaveRequire().stream()
//                .filter(request -> request.getEmployee().getEmployeeId().equals(employee.getEmployeeId()))
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);

//    @GetMapping("/leave_request/{id}")
//    public ResponseEntity<LeaveRequire> getLeaveRequestById(@PathVariable("id") Integer id) {
//        LeaveRequire leaveRequest = leaveRequireService.getLeaveRequireById(id).orElseThrow(() -> new IllegalArgumentException("Leave request not found"));
//        return new ResponseEntity<>(leaveRequest, HttpStatus.OK);
//    }

}
