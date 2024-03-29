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
public class Profile  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFILE")
    @SequenceGenerator(sequenceName = "profile_seq", allocationSize = 1, name = "PROFILE")
    @Column(length = 10, name = "PROFILE_ID", nullable = false)
    private Integer profileId;

    @Column(length = 100, name = "STATUS", nullable = false)
    private Integer status;


}
