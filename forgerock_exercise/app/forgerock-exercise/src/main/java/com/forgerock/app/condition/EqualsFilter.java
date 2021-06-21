package com.forgerock.app.condition;

import java.util.*;


public class EqualsFilter implements Filter {

    private String property;
    private String value;

    public EqualsFilter(String property, String value) {

        this.property = property;
        this.value = value;
    }

    /**
    * Checks if exact the input value to matches to a value in a resource. 
    * Values are not case sensitive.
    *
    * @param resource  the resource to be filtered.  If the resource is null, 
    *              return false.
    */
    @Override
    public boolean matches(Map<String, String> resource) {
        String val = resource.get(property);
        return val != null && val.equalsIgnoreCase(value);
    }
}
