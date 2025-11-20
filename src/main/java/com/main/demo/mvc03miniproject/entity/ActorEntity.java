package com.main.demo.mvc02miniproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class ActorEntity {
    //Data properties
    @Id
    @SequenceGenerator(name = "gen1",sequenceName = "actor",initialValue = 100,allocationSize=1)
    @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
    private Integer aid;

    @Column(length = 30)
    @NonNull
    private String aname;

    @Column(length = 30)
    @NonNull
    private String addrs;

    @Column(length = 30)
    @NonNull
    private String category;

    @NonNull
    private Double remuneration;

    //Meta Data properties

    @Version
    private Integer updateCount;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;


    @Column(length = 30)
    private String createdBy;

    @Column(length = 30)
    private String updatedBy;

    @Column(length = 30)
    private String active_SW ="active";


}
