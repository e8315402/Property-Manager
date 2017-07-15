package model;

import schema.Property;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by JianFa on 2017/7/15.
 */
public class PropertyContainer {

    Map<String, Property> propertyMap;

    public PropertyContainer () {
        propertyMap = new HashMap<>();
    }

    public void add(Property p) throws IOException {
        if(propertyMap.containsKey(p.getNumber())) throw new IOException("Already has the same property.");
        propertyMap.put(p.getNumber(), p);
    }

    public Property getPropertyByNumber(String number) {
        if(!propertyMap.containsKey(number)) throw new NoSuchElementException("Property number is incorrect.");
        return propertyMap.get(number);
    }

}
