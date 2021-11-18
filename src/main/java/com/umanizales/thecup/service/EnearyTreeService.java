package com.umanizales.thecup.service;

import com.umanizales.thecup.aplication.dto.ResponseBinaryTreeDto;
import com.umanizales.thecup.exception.BinaryTreeException;
import com.umanizales.thecup.exception.DataNotFoundException;
import com.umanizales.thecup.exception.EnearyTreeException;
import com.umanizales.thecup.model.EnearyNode;
import com.umanizales.thecup.model.EnearyTree;
import com.umanizales.thecup.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.prefs.BackingStoreException;

@Service
public class EnearyTreeService
{
    private EnearyTree nTree= new EnearyTree();

    public ResponseEntity<ResponseBinaryTreeDto> add(Player boy, int parentIdentification) throws BinaryTreeException, DataNotFoundException, EnearyTreeException
    {
        nTree.add(boy,parentIdentification);
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(boy,"Se ha guardado exitosamente",
                        null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> listBoys()
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(nTree.getRoot(),"Success", null)
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<ResponseBinaryTreeDto> calculateDiscount(int id) throws DataNotFoundException, BinaryTreeException
    {
        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(true,"El jugador tiene un descuento de: "
                        + nTree.calculateDiscount(id) + "%", null),HttpStatus.OK);
    }
}
