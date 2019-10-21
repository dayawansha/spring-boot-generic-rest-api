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
@Table(name = "PROFILE")
@DynamicUpdate
public class Bonus implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BONUS")
    @SequenceGenerator(sequenceName = "profile_seq", allocationSize = 1, name = "BONUS")
    @Column(length = 10, name = "BONUS_ID", nullable = false)
    private Integer bonusId;

    @Column(length = 100, name = "STATUS", nullable = false)
    private String name;

    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

}