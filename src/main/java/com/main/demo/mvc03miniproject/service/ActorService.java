package com.main.demo.mvc03miniproject.service;

import com.main.demo.mvc03miniproject.dto.ActorDTO;
import com.main.demo.mvc03miniproject.entity.ActorEntity;
import com.main.demo.mvc03miniproject.exception.ActorNotFoundException;
import com.main.demo.mvc03miniproject.repositories.IActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService implements IActorMgmtService {


    private final IActorRepository actorRepo;
    @Override
    public List<ActorDTO> showAllActorDetails() {
        //use repo
        List<ActorEntity> actorEntities = actorRepo.findAll();
        // empty actroDTO
        List<ActorDTO> actorDTOs = new ArrayList<>();

        // copy the actorEntities to actorDtos list using for each
        for (ActorEntity actorEntity : actorEntities) {
            //new dto
            ActorDTO actorDTO = new ActorDTO();
            //copy each entity to new dto and add to the list
            BeanUtils.copyProperties(actorEntity, actorDTO);
            actorDTOs.add(actorDTO);
        }


        return actorDTOs;
    }

    @Override
    public String saveActor(ActorDTO actorDTO) {
        ActorEntity actorEntity = new ActorEntity();

        //                        src       entity
        BeanUtils.copyProperties(actorDTO, actorEntity);

        //set the metadata properties
        actorEntity.setCreatedBy(System.getProperty("user.name"));
        actorEntity.setUpdatedBy(System.getProperty("Harsh"));

        //use the save method
        Integer aid = actorRepo.save(actorEntity).getAid();

        return aid + "id actor is saved successfully";


    }

    @Override
    public ActorDTO findActorById(int id) {
        ActorEntity actorEntity = actorRepo.findById(id).orElseThrow(()->new ActorNotFoundException("Actor not found"));

        ActorDTO actorDTO = new ActorDTO();

        BeanUtils.copyProperties(actorEntity, actorDTO);

        return actorDTO;

    }

    @Override
    public String updateActor(ActorDTO actorDTO) {
        Integer aid = actorDTO.getAid();
        ActorEntity actorEntity = actorRepo.findById(aid).orElseThrow(()->new ActorNotFoundException("Actor not found"));

        BeanUtils.copyProperties(actorDTO, actorEntity);

        Integer id = actorRepo.save(actorEntity).getAid();

        return "Actor with id val "+id+" is updated successfully";



    }


    @Override
    public String deleteActor(Integer id) {

        ActorEntity actor = actorRepo.findById(id)
                .orElseThrow(() -> new ActorNotFoundException("Actor not found"));

        actorRepo.delete(actor);

        return "Actor with ID " + id + " deleted successfully";
    }

}
