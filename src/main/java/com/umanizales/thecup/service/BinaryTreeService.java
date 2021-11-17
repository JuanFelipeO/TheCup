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
                new ResponseBinaryTreeDto(binaryTree.listPlayers(which),"Acción exitosa",
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
                new ResponseBinaryTreeDto(binaryTree.counterEqualNum(node,number),"Acción exitosa",
                        null),HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDto> listGetLeafs() throws BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getLeafs(),"Acción exitosa",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> createTournament(int totalPlayers) throws BinaryTreeException
    {
        binaryTree.setRoot(null);
        binaryTree.setCount(0);
        int variant=totalPlayers*2;
        totalPlayers= totalPlayers +(totalPlayers-1);
        int level=1;
        int start= variant/2;
        int i=1;
        while(i < totalPlayers)
        {
            int totalHorizontal = (int) Math.pow(2,(level-1));
            int ind = start;
            for(int j=0;j<totalHorizontal;j++)
            {
                binaryTree.addPlayer(new Player(ind,"Player",true));
                ind= ind + variant;
                i++;
            }
            variant= variant/2;
            start=start/2;
            level++;
        }

        return new ResponseEntity<ResponseBinaryTreeDto>(
                new ResponseBinaryTreeDto(binaryTree.getRoot(),"Success", null)
                ,HttpStatus.OK
        );
    }

    public ResponseEntity<ResponseBinaryTreeDto> loginPlayer(Player data, int identification) throws BinaryTreeException
    {
        binaryTree.loginPlayer(data,identification);
        return new ResponseEntity<>(new ResponseBinaryTreeDto(data,"Se añadio correctamente el jugador al torneo",
                null), HttpStatus.OK);
    }
}
