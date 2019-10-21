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
@Table(name = "CUSTOMER")
@DynamicUpdate
public class Customer implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUSTOMER")
    @Column(length = 10, name = "CUSTOMER_ID", nullable = false)
    private Integer customerId;

    @Column(length = 100, name = "CUSTOMER_Name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employee> employeeSet;

}
