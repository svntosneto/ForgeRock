package com.forgerock.app.condition;

import java.util.*;

public class BooleanFilter implements Filter {

    private boolean value;

    public BooleanFilter(Boolean value) {
        this.value = value;
    }

    /**
    * Checks if exact the value is true or false.
    *
    * @param resource  the resource to be filtered.  
    */
    @Override
    public boolean matches(Map<String, String> resource) {
        return value;
    }
}