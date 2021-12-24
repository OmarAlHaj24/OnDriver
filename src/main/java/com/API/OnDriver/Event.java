package com.API.OnDriver;

import java.util.ArrayList;

public class Event {
    private EventName name;
    private ArrayList<String> attributes = new ArrayList<>();
    public void addAttribute(String attribute){
        attributes.add(attribute);
    }
    public void setName(EventName name){
        this.name = name;
    }
}