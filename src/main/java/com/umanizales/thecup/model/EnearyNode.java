package com.umanizales.thecup.model;

import lombok.Data;

import java.util.List;

@Data
public class EnearyNode {
    private Player data;
    private List<EnearyNode> children;

    public EnearyNode(Player data) {
        this.data = data;

    }


    public EnearyNode findEnearyTreeByIdentification(int identification)
    {
        if(this.getData().getIdPlayer()==identification)
        {
            return this;
        }
        else
        {
            if(this.children!=null) {
                for (EnearyNode child : children) {
                    EnearyNode nodeFind = child.findEnearyTreeByIdentification(identification);
                    if (nodeFind != null) {
                        return nodeFind;
                    }
                }
            }

        }
        return null;

    }
}
