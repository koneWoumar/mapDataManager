package com.example.mapDataManager.entities;

public class Node extends Location{
    //long id ;
    Point point;
    public Node(long id,Point point,String name){
        this.point=point;
        this.name=name;
        this.id=id;
        this.type="node";
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String toString(){
        String ptr = "******************\nid = "+id+"\nname = "+name+"\npoint = "+point.toString();
        return(ptr);
    }
}
