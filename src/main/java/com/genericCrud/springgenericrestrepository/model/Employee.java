package com.genericCrud.springgenericrestrepository.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE")
@DynamicUpdate
public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE")
    @SequenceGenerator(sequenceName = "employee_seq", allocationSize = 1, name = "EMPLOYEE")
    @Column(length = 14, name = "EMPLOYEE_ID", nullable = false)
    private Long profileId;
    @Column(length = 5, name = "STATUS", nullable = false)
    private String status;
}

