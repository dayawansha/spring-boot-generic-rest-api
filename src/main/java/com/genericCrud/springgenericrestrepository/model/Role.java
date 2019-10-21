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
@Table(name = "ROLE")
@DynamicUpdate
public class Role implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE")
    @SequenceGenerator(sequenceName = "role_seq", allocationSize = 1, name = "ROLE")
    @Column(length = 5, name = "ID_TYPE_ID", nullable = false)
    private Integer idTypeId;
}
