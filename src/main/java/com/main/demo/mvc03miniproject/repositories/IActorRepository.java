package com.main.demo.mvc03miniproject.repositories;

import com.main.demo.mvc03miniproject.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IActroRepository extends JpaRepository<ActorEntity, Integer> {
}
