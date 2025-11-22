package com.main.demo.mvc03miniproject.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {

    private Integer aid;
    @NonNull
    private String aname;

    @NonNull
    private String addrs;

    @NonNull
    private String category;

    @NonNull
    private Double remuneration;

}
