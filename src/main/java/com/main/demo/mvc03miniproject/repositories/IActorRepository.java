package com.main.demo.mvc03miniproject.repositories;

import com.main.demo.mvc03miniproject.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IActorRepository extends JpaRepository<ActorEntity, Integer> {
}
