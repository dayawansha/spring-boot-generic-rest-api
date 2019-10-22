package com.genericCrud.springgenericrestrepository.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "AGENT")
@DynamicUpdate
public class Agent implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENT")
    @SequenceGenerator(sequenceName = "agent_seq", allocationSize = 1, name = "AGENT")
    @Column(length = 14, name = "AGENT_ID", nullable = false)
    private Integer agentId;

    @Column(length = 100, name = "NAME", nullable = false)
    private String name;

//    @JsonIgnore
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;

//    @JsonIgnore
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Department department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agent", fetch = FetchType.EAGER)
    private Set<Bonus> bonusSet;

}

