package com.main.demo.mvc03miniproject.service;

import com.main.demo.mvc03miniproject.dto.ActorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface IActorMgmtService {

    public List<ActorDTO> showAllActorDetails();
    public String saveActor(ActorDTO actorDTO);
    public ActorDTO findActorById(int id);
    public String updateActor(ActorDTO actorDTO);
    public String deleteActor(Integer id);

    public Page<ActorDTO> findActorByPage(Pageable pageable);

}
