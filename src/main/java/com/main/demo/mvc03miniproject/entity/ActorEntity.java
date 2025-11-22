package com.main.demo.mvc03miniproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACTOR_ENTITY")
//It makes sure that whenever delete statement is executed using pure jpa methods this statement executes
@SQLDelete(sql ="UPDATE ACTOR_ENTITY SET ACTIVE_SW='inactive' WHERE AID=? AND UPDATE_COUNT=?")
//this restricts the select statement that whenever select happen ignore the inactive part
@SQLRestriction("ACTIVE_SW != 'inactive'")


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
