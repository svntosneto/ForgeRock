package com.forgerock.app.condition;

import java.util.*;

public class AndFilter implements Filter {

    private Filter c1;
    private Filter c2;

    public AndFilter(Filter c1, Filter c2) {

        this.c1 = c1;
        this.c2 = c2;
    }

    /**
    * Combines 2 filters according the logic operator AND and check if resources match criteria.
    *
    * @param resource  the resource to be filtered.  If the resource is null, 
    *              it will return false due to other filter definitions.
    */
    @Override
    public boolean matches(Map<String, String> resource) {
        return c1.matches(resource) && c2.matches(resource);
    }
}