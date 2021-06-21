package com.forgerock.app.condition;

import java.util.*;

public class PresentFilter implements Filter {

    private String property;

    public PresentFilter(String property) {
        this.property = property;
    }

    /**
    * Checks if property is present in the resource. Property is case sensitive.
    *
    * @param resource  the resource to be filtered.  If the resource is null, 
    *              return false.
    */

    @Override
    public boolean matches(Map<String, String> resource) {
        return resource.containsKey(property);
    }
}