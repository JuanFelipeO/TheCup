package com.umanizales.thecup.model;

import com.umanizales.thecup.exception.DataNotFoundException;
import com.umanizales.thecup.exception.EnearyTreeException;
import lombok.Data;

import java.util.ArrayList;

@Data
public class EnearyTree {
    private EnearyNode root;
    private int count;

    public void add(Player child, int parentIdentification) throws EnearyTreeException, DataNotFoundException {
        if (root == null) {
            root = new EnearyNode(child);
        } else {
            EnearyNode parent = root.findEnearyTreeByIdentification(parentIdentification);
            if (parent == null) {
                throw new DataNotFoundException("No existe un nodo con la identificación " + parentIdentification);
            }
            EnearyNode childFind = root.findEnearyTreeByIdentification(child.getIdPlayer());
            if (childFind != null) {
                throw new EnearyTreeException("Ya existe un nodo con la identificación " + child.getIdPlayer());
            }
            if (parent.getChildren() == null)
                parent.setChildren(new ArrayList<>());
            parent.getChildren().add(new EnearyNode(child));
        }
    }

    public void validateNtreeEmpty() throws EnearyTreeException {
        if (this.root == null)
            throw new EnearyTreeException("El árbol eneario está vacío");
    }
}