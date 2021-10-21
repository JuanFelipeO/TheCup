package com.umanizales.thecup.service;

import com.umanizales.thecup.aplication.dto.ResponseBinaryTreeDto;
import com.umanizales.thecup.exception.BinaryTreeException;
import com.umanizales.thecup.model.BinaryNode;
import com.umanizales.thecup.model.BinaryTree;
import com.umanizales.thecup.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BinaryTreeService
{
    private BinaryTree binaryTree = new BinaryTree();

    public ResponseEntity<ResponseBinaryTreeDto> addPlayer(Player player) throws BinaryTreeException
    {
        binaryTree.addPlayer(player);
        return new ResponseEntity<>(new ResponseBinaryTreeDto(player,"El jugador se creo correctamente",
                null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> listPlayers(int which) throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.listPlayers(which),"Exitoso",
                        null),HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> count()
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getCount(),"El contador esta vacio",
                        null),HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> counterEqualNum(BinaryNode node, int number) throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.counterEqualNum(node,number),"Exitoso",
                        null),HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> listGetLeafs() throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getLeafs(),"Exitoso",
                        null),HttpStatus.OK);

    }
}
