package com.umanizales.thecup.controller;

import com.umanizales.thecup.exception.BinaryTreeException;
import com.umanizales.thecup.exception.DataNotFoundException;
import com.umanizales.thecup.exception.EnearyTreeException;
import com.umanizales.thecup.model.EnearyNode;
import com.umanizales.thecup.model.Player;
import com.umanizales.thecup.service.EnearyTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "enearytree")
@Validated
@CrossOrigin("http://localhost:4200")
public class EnearyTreeController
{
    @Autowired
    private EnearyTreeService enearyTreeService;

    @PostMapping("/add/{parentIdentification}")
    public  @ResponseBody
    ResponseEntity<?> add (@Validated @RequestBody Player player, @PathVariable int parentIdentification) throws BinaryTreeException, DataNotFoundException, EnearyTreeException
    {
        return enearyTreeService.add(player,parentIdentification);
    }

    @GetMapping("/listplayers")
    public @ResponseBody
    ResponseEntity<?> listBoys() throws DataNotFoundException
    {
        return enearyTreeService.listBoys();
    }

    @GetMapping("/calculatediscount/{id}")
    public @ResponseBody
    ResponseEntity<?> calculateDiscount(@PathVariable int id) throws DataNotFoundException, BinaryTreeException
    {
        return enearyTreeService.calculateDiscount(id);
    }
}
