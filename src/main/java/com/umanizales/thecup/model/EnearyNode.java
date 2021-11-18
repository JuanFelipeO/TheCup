package com.umanizales.thecup.model;

import com.umanizales.thecup.exception.BinaryTreeException;
import lombok.Data;

import java.util.List;

@Data
public class EnearyNode
{
    private Player data;
    private List<EnearyNode> children;

    public EnearyNode(Player data)
    {
        this.data = data;
    }


    public EnearyNode findEnearyTreeByIdentification(int identification) throws BinaryTreeException
    {
        if(this.getData().getIdPlayer()==identification)
        {
            return this;
        }
        else
        {
            if(this.children!=null)
            {
                for (EnearyNode child : children)
                {
                    EnearyNode nodeFind = child.findEnearyTreeByIdentification(identification);
                    if (nodeFind != null)
                    {
                        return nodeFind;
                    }
                }
            }
        }
        return null;
    }

    public int getHeight(EnearyNode node)
    {
        if (node.getChildren() == null)
        {
            return 0;
        } else
        {
            int maxHeight = 1;
            for (EnearyNode child : node.getChildren())
            {
                maxHeight = Math.max(maxHeight, getHeight(child));
            }
            return maxHeight + 1;
        }
    }

    public int calculateDiscount(EnearyNode node) throws BinaryTreeException
    {
        //this.findEnearyTreeByIdentification(id);
        int level = 0;
        int discountTotal;
        int discount1 = 0;
        int discount2 = 0;
        int discount3 = 0;

        while (level < getHeight(node))
        {
            if (level == 1)
            {
                discount1 = 5;
            }
            if (level == 2)
            {
                discount2 = 2;
            }
            if (level >= 3)
            {
                discount3 = discount3+1;
            }
            level++;
        }
        discountTotal = discount1+discount2+discount3;
        return discountTotal;
    }
}
