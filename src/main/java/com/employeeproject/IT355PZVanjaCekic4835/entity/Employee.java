package com.employeeproject.IT355PZVanjaCekic4835.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "registration_number")
    private Integer registrationNumber;

    @Column(name = "password")
    private String password;

//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Role> roles = new HashSet<>();
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "employee_role",
//            joinColumns = @JoinColumn(name = "employee_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_role",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return employeeId.equals(that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }


    public Employee() {
    }

    public Employee(Integer employeeId, String name, String lastname, String email, Integer registrationNumber, String password, Set<Role> roles) {
        this.employeeId = employeeId;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.registrationNumber = registrationNumber;
        this.password = password;
        this.roles = roles;
    }

    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
//                .collect(Collectors.toList());
//    }

}
