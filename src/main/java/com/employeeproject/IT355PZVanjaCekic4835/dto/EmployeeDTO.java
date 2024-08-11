package com.employeeproject.IT355PZVanjaCekic4835.dto;

import com.employeeproject.IT355PZVanjaCekic4835.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class EmployeeDTO {
    private Integer employeeId;
    private String name;
    private String lastname;
    private String email;
    private Integer registrationNumber;
    private Set<RoleType> roles;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer employeeId, String name, String lastname, String email, Integer registrationNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.registrationNumber = registrationNumber;
    }

    public EmployeeDTO(Integer employeeId, String name, String lastname, String email, Integer registrationNumber, Set<RoleType> roles) {
        this.employeeId = employeeId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.registrationNumber = registrationNumber;
        this.roles = roles;
    }


//    private Integer employeeId;
//    private String name;
//    private String lastname;
//    private String email;
//    private Integer registrationNumber;
//    private List<RoleType> roles;
//
//    public EmployeeDTO(Integer employeeId, String name, String lastname, String email, Integer registrationNumber, List<RoleType> roles) {
//        this.employeeId = employeeId;
//        this.name = name;
//        this.lastname = lastname;
//        this.email = email;
//        this.registrationNumber = registrationNumber;
//        this.roles = roles;
//    }
//
//    public EmployeeDTO() {
//    }
}
//package com.employeeproject.IT355PZVanjaCekic4835.dto;
//
//import com.employeeproject.IT355PZVanjaCekic4835.enums.RoleType;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.Set;
//
//
//@Setter
//@Getter
//public class EmployeeDTO {
//    private Integer employeeId;
//    private String name;
//    private String lastname;  private String email;
//    private Integer registrationNumber;
//    private Set<RoleType> roles;
//
//    public EmployeeDTO(Integer employeeId, String name, String lastname, Set<RoleType> roles) {
//    }
//
//    public EmployeeDTO(String name, String lastname, Integer registrationNumber, String email, Set<RoleType> roles) {
//        this.name = name;
//        this.lastname = lastname;
//        this.registrationNumber = registrationNumber;
//        this.email = email;
//        this.roles = roles;
//    }
//}
