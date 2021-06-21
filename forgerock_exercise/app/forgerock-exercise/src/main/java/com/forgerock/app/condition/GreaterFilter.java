package com.forgerock.app.condition;

import java.util.*;


public class GreaterFilter implements Filter {

    private String property;
    private String value;

    public GreaterFilter(String property, String value) {

        this.property = property;
        this.value = value;
    }
    /**
    * Checks if a value in a resource is greater than the input value. Values are converted to Int
    * @param Integer.parseInt ensures the values are integers
    * @param resource  the resource to be filtered.  If the resource is null, 
    *              return false.
    */
    @Override
    public boolean matches(Map<String, String> resource) {
        String val = resource.get(property);
        int intVal = Integer.parseInt(val);
        int intValue = Integer.parseInt(value);

        return val != null && intVal > intValue;
    }
}
