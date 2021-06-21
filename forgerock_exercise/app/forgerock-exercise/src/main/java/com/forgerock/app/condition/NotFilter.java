package com.forgerock.app.condition;

import java.util.*;

public class NotFilter implements Filter {

    private Filter c1;
    
    public NotFilter(Filter c1) {
        this.c1 = c1;
    }

    /**
    * Negates a filter according the logic operator NOT.
    *
    * @param resource  the resource to be filtered.  If the resource is null, 
    *              it will return false due to other filter definitions.
    */
    @Override
    public boolean matches(Map<String, String> resource) {
        return !c1.matches(resource);
    }
}