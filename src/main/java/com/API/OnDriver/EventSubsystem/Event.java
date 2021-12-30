package com.API.OnDriver.EventSubsystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Event {
    private EventName name;
    private Map<String, String> attributes = new LinkedHashMap<>();

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
            result += "Added Price: ";

        } else if (name == EventName.acceptedOffer) {
            result += "Accepted Offer: ";

        } else if (name == EventName.arrivedToSource) {
            result += "Arrived To Source: ";

        } else {
            result += "Arrived To Destination: ";

        }
        boolean flag = false;
        for (Map.Entry<String, String> set : attributes.entrySet()) {
            if (flag) {
                result += " || ";
            }
            result += set.getKey() + ": " + set.getValue();
            flag = true;
        }

        return result;
    }

}