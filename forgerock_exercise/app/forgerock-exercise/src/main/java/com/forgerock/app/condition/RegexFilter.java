package com.forgerock.app.condition;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexFilter implements Filter {

    private String property;
    private String value;

    public RegexFilter(String property, String value) {

        this.property = property;
        this.value = value;
    }

    /**
    * Checks if there is a partial match between input value to matches to a value in a resource. 
    * Values are not case sensitive.
    *
    * @param resource  the resource to be filtered.  If the resource is null, 
    *              return false.
    */
    @Override
    public boolean matches(Map<String, String> resource) {
        String val = resource.get(property);
        Pattern pattern = Pattern.compile(value, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(val);
        boolean matchFound = matcher.find();
        return val != null && matchFound;
    }
}