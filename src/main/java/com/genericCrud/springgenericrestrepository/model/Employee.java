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

    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Bonus> bonusSet;

}

