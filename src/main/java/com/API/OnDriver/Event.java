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

    @Override
    public String toString(){
        String result = "";
        if(name == EventName.addedPrice){
            result += "Added Price: ";
            
        }else if(name == EventName.acceptedOffer){
            result += "Accepted Offer: ";

        }else if(name == EventName.arrivedToSource){
            result += "Arrived To Source: ";

        }else{
            result += "Arrived To Destination: ";

        }
        return result;
    }
}