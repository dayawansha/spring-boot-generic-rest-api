package com.genericCrud.springgenericrestrepository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT")
@DynamicUpdate
public class Department implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT")
    @SequenceGenerator(sequenceName = "department_seq", allocationSize = 1, name = "DEPARTMENT")
    @Column(length = 5, name = "DEPARTMENT_ID", nullable = false)
    private Integer departmentId;

    @Column(length = 50, name = "DEPARTMENT_NAME", nullable = false)
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employee> employeeSet;


}
