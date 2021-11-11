package com.umanizales.thecup.controller;

import com.umanizales.thecup.exception.BinaryTreeException;
import com.umanizales.thecup.model.BinaryNode;
import com.umanizales.thecup.model.Player;
import com.umanizales.thecup.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "binarytree")
@Validated
public class BinaryTreeController
{
    @Autowired
    private BinaryTreeService binaryTreeService;

    @PostMapping("/add")
    public @ResponseBody
    ResponseEntity<?> addBoy(@Valid @RequestBody Player player) throws BinaryTreeException
    {
        return binaryTreeService.addPlayer(player);
    }

    @GetMapping("/preorden")
    public @ResponseBody
    ResponseEntity<?> listPlayerPreOrden() throws BinaryTreeException
    {
        return binaryTreeService.listPlayers(1);
    }

    @GetMapping("/inorden")
    public @ResponseBody
    ResponseEntity<?> listPlayerInOrden() throws BinaryTreeException
    {
        return binaryTreeService.listPlayers(2);
    }

    @GetMapping("/postorden")
    public @ResponseBody
    ResponseEntity<?> listPlayerPostOrden() throws BinaryTreeException
    {
        return binaryTreeService.listPlayers(3);
    }

    @GetMapping("/count")
    public @ResponseBody
    ResponseEntity<?> countBinaryTree() throws BinaryTreeException
    {
        return binaryTreeService.count();
    }

    @GetMapping("/countnumber")
    public @ResponseBody
    ResponseEntity<?> counterEqualNum(Path.Node node, int number) throws BinaryTreeException
    {
        return binaryTreeService.counterEqualNum((BinaryNode) node,number);
    }

    @GetMapping("/listLeaves")
    public @ResponseBody
    ResponseEntity<?> listLeaf() throws BinaryTreeException
    {
        return binaryTreeService.listGetLeafs();
    }

    @GetMapping("/createtournament/{totalPlayers}")
    public @ResponseBody
    ResponseEntity<?> createTournament(@PathVariable int totalPlayers) throws BinaryTreeException {
        return binaryTreeService.createTournament(totalPlayers);
    }
}
