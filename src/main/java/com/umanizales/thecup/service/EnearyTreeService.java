package com.umanizales.thecup.service;

import com.umanizales.thecup.aplication.dto.ResponseBinaryTreeDto;
import com.umanizales.thecup.exception.DataNotFoundException;
import com.umanizales.thecup.exception.EnearyTreeException;
import com.umanizales.thecup.model.EnearyTree;
import com.umanizales.thecup.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnearyTreeService
{
    private EnearyTree nTree= new EnearyTree();

    public ResponseEntity<ResponseBinaryTreeDto> add(Player boy, int parentIdentification) throws DataNotFoundException, EnearyTreeException
    {
        nTree.add(boy,parentIdentification);
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(boy,"Se ha guardado exitosamente",
                        null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> listBoys() throws DataNotFoundException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(nTree.getRoot(),"Success", null)
                ,HttpStatus.OK
        );
    }
}
