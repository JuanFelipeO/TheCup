package com.umanizales.thecup.model;

import com.umanizales.thecup.exception.BinaryTreeException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BinaryTree
{
    private BinaryNode root;
    private int count;

    public void addPlayer(Player data) throws BinaryTreeException
    {
        if(root==null)
        {
            root = new BinaryNode(data);
        }
        else
        {
            root.addPlayer(data);
        }
        count ++;
    }

    public List<Player> listPlayers(int which) throws BinaryTreeException
    {
        List<Player> listPlayers = new ArrayList<>();
        switch (which){
            case 1:
                return root.listPlayerPreOrden();
            case 2:
                return root.listPlayerInOrden();
            case 3:
                return root.listPlayerPostOrden();
        }

        throw new BinaryTreeException("No hay datos de jugadores para mostrar");
    }

    public int counterEqualNum(BinaryNode node, int number)throws BinaryTreeException
    {
        if(node != null)
        {
            int cont=0;
            if(node.getData().getIdPlayer()%10 == number)
            {
                cont = 1;
            }
            return cont + counterEqualNum(node.getLeft(), number) + counterEqualNum(node.getRight(),number);
        }
        throw new BinaryTreeException("No existen jugadores con este numero en comun");
    }

    public List<Player> getLeafs() throws BinaryTreeException
    {
        if(root!=null)
        {
            return root.getLeafs();
        }
        else
        {
            throw new BinaryTreeException("El árbol esta vacio");
        }
    }
}
