package com.API.OnDriver;

import java.util.ArrayList;
import java.util.HashMap;

public class Event {
    private EventName name;
    private HashMap<String, String> attributes = new HashMap<>();

    public void addAttribute(String attribute, String value) {
        attributes.put(attribute, value);
    }

    public void setName(EventName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String result = "";
        if (name == EventName.addedPrice) {
            result += "Added Price: \n";

        } else if (name == EventName.acceptedOffer) {
            result += "Accepted Offer: \n";

        } else if (name == EventName.arrivedToSource) {
            result += "Arrived To Source: \n";

        } else {
            result += "Arrived To Destination: \n";

        }
        for (HashMap.Entry<String, String> set : attributes.entrySet()) {

            result += set.getKey() + ": " + set.getValue() + "\n";
        }

        return result;
    }

}