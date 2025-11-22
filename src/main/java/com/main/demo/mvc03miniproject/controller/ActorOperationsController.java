package com.main.demo.mvc03miniproject.controller;


import com.main.demo.mvc03miniproject.dto.ActorDTO;
import com.main.demo.mvc03miniproject.service.IActorMgmtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ActorOperationsController {

    private final IActorMgmtService actorMgmtService;

    @GetMapping("/")
    public String showHome(){
        System.out.println("showHome");
        //return logical view name
        return "welcome";
    }

    //Map for passing the dtos to the jsp page
    @GetMapping("/report")
    public String showReport(Map<String, Object> model){
        System.out.println("showReport");
        //use service class method to get the all ActorDtos

        List<ActorDTO> actorDtos = actorMgmtService.showAllActorDetails();

        //put the data in the model attribute for sharing with the jsp page
        model.put("actorDtos", actorDtos);



        return "show_report";
    }

    @GetMapping("/add")
    public String showAdd(@ModelAttribute("actor") ActorDTO actorDTO){
        return "register_actor_form";
    }

    @PostMapping("/add")
    public String saveActor(@ModelAttribute("actor") ActorDTO actorDTO,
                            RedirectAttributes redirectAttrs){
        String msg = actorMgmtService.saveActor(actorDTO);

        redirectAttrs.addFlashAttribute("resultMap", msg);

        return "redirect:/report";  // post redirect get pattern for solving data duplication
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam("no") Integer id,
                           @ModelAttribute("actor") ActorDTO actorDTO) {

        System.out.println("Editing actor with ID: " + id);

        ActorDTO dto = actorMgmtService.findActorById(id);

        if (dto == null) {
            throw new IllegalArgumentException("Actor not found with ID: " + id);
        }

        BeanUtils.copyProperties(dto, actorDTO);

        return "edit_actor_form";
    }

    @PostMapping("/update")
    public String updateActor(@ModelAttribute("actor") ActorDTO actorDTO,
                              RedirectAttributes redirectAttrs) {

        String msg = actorMgmtService.updateActor(actorDTO);

        redirectAttrs.addFlashAttribute("resultMap", msg);

        return "redirect:/report";
    }

    @GetMapping("/delete")
    public String deleteActor(@RequestParam("no") Integer id,
                              RedirectAttributes redirectAttrs) {

        String msg = actorMgmtService.deleteActor(id);

        redirectAttrs.addFlashAttribute("resultMap", msg);

        return "redirect:/report";   // PRG pattern
    }








}
