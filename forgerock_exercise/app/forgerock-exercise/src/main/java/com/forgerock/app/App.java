package com.forgerock.app;

import java.util.*;

import com.forgerock.app.condition.Comparison;
import com.forgerock.app.condition.Filter;
import com.forgerock.app.condition.FilterFactory;
import com.forgerock.app.condition.Logical;

public class App 
{
    public static void main( String[] args )
    {
        
        // Create user resource having various properties:
        Map<String, String> user = new LinkedHashMap<String, String>();
        user.put("firstname", "Joe");
        user.put("surname", "Bloggs");
        user.put("role", "administrator");
        user.put("age", "35");

        // Create a filter which matches all administrators older than 30:
        FilterFactory filterFactory = new FilterFactory();
        Filter equals = filterFactory.getComparison(Comparison.EQUALS, "role", "administrator");
        Filter greater = filterFactory.getComparison(Comparison.GREATER, "age", "30");
        boolean result = false;

        Filter filter = filterFactory.getLogical(Logical.AND, equals, greater);
        result = filter.matches(user);
        assert result; // Filter should match.
        System.out.println("Administrators older than 30:");
        System.out.println(user + " " + "User Matches?" + " " + result);
        
        user.put("age", "25");
        result = filter.matches(user);
        assert result; // Filter should match.
        System.out.println(user + " " + "User Matches?" + " " + result); // Filter should not match.
    }
}
