package com.umanizales.thecup.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Player
{
    @NotNull
    private int idPlayer;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;
    private boolean wildcard;
}
