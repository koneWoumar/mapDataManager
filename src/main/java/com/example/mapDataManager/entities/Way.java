package com.example.mapDataManager.entities;

import java.util.ArrayList;

public class Way extends Location{
    ArrayList<Point> points;
    public Way(long id,String name){
        this.points=new ArrayList<>();
        this.name=name;
        this.id=id;
        this.type="way";
    }
}
