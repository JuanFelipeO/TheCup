package com.umanizales.thecup.aplication.dto;

import com.umanizales.thecup.controller.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseBinaryTreeDto {

    private Object data;
    private String message;
    private List<ErrorDTO> errors;
}
