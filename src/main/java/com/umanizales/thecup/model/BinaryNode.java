package com.umanizales.thecup.model;

import com.umanizales.thecup.exception.BinaryTreeException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@ToString
public class BinaryNode
{
    private Player data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(Player data)
    {
        this.data = data;
    }

    public boolean isLeaft()
    {
        return left == null && right == null;
    }

    public void addPlayer(Player data) throws BinaryTreeException
    {
        if(data.getIdPlayer() < this.getData().getIdPlayer())
        {
            if(this.getLeft()==null)
            {
                this.setLeft(new BinaryNode(data));
            }
            else
            {
                this.left.addPlayer(data);
            }
        }
        else if (data.getIdPlayer() > this.getData().getIdPlayer())
        {
            if(this.getRight()==null)
            {
                this.setRight(new BinaryNode(data));
            }
            else
            {
                this.right.addPlayer(data);
            }
        }
        else
        {
            throw new BinaryTreeException("Ya existe un jugador con esa identificación");
        }
    }

    public List<Player> listPlayerPreOrden() {
        List<Player> listBoysPreOrden = new ArrayList<>();
        listBoysPreOrden.add(this.getData());
        if(this.getLeft() != null)
        {
            listBoysPreOrden.addAll(this.getLeft().listPlayerPreOrden());
        }
        if(this.getRight() != null)
        {
            listBoysPreOrden.addAll(this.getRight().listPlayerPreOrden());
        }
        return  listBoysPreOrden;
    }

    public List<Player> listPlayerInOrden()
    {
        List<Player> listPlayerInOrden = new ArrayList<>();
        if(this.getLeft() != null)
        {
            listPlayerInOrden.addAll(this.getLeft().listPlayerInOrden());
        }
        listPlayerInOrden.add(this.getData());
        if(this.getRight() != null)
        {
            listPlayerInOrden.addAll(this.getRight().listPlayerInOrden());
        }
        return listPlayerInOrden;
    }

    public List<Player> listPlayerPostOrden()
    {
        List<Player> listPlayerPostOrden = new ArrayList<>();
        if(this.getLeft() != null)
        {
            listPlayerPostOrden.addAll(this.getLeft().listPlayerPostOrden());
        }
        if(this.getRight() != null)
        {
            listPlayerPostOrden.addAll(this.getRight().listPlayerPostOrden());
        }
        listPlayerPostOrden.add(this.getData());
        return listPlayerPostOrden;
    }

    public List<Player> listEqualNum(int number)
    {
        List<Player> listEqualNum = new ArrayList<>();
        listEqualNum.add(this.getData());
        if (this.getLeft() != null)
        {
            if (this.getData().getIdPlayer() % 10 == number)
            {
                listEqualNum.addAll(this.getLeft().listEqualNum(number));
            }
        }

        if (this.getRight() != null)
        {
            if (this.getData().getIdPlayer() % 10 == number)
            {
                listEqualNum.addAll(this.getRight().listEqualNum(number));
            }
        }
        return listEqualNum;
    }

    public List<Player> getLeafs()
    {
        List<Player> getLeafs = new ArrayList<>();
        if (this.isLeaft())
        {
            getLeafs.add(this.getData());
        } else
        {
            if (this.getLeft() != null)
            {
                getLeafs.addAll(this.getLeft().getLeafs());
            }
            if (this.getRight() != null)
            {
                getLeafs.addAll(this.getRight().getLeafs());
            }
        }
        return getLeafs;
    }

    public void loginPlayer(Player data, int identification) throws BinaryTreeException
    {
        if(data.getIdPlayer() < identification)
        {
            if(this.getLeft()==null)
            {
                this.setLeft(new BinaryNode(data));
            }
            else
            {
                this.left.setData(data);
            }
        }
        else if (data.getIdPlayer() > identification)
        {
            if(this.getRight()==null)
            {
                this.setRight(new BinaryNode(data));
            }
            else
            {
                this.right.setData(data);
            }
        }
        else
        {
            throw new BinaryTreeException("Ya existe un jugador con esa identificación");
        }
    }
}
