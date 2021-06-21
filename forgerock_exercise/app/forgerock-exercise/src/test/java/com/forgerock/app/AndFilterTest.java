package com.forgerock.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.forgerock.app.condition.AndFilter;
import com.forgerock.app.condition.EqualsFilter;
import com.forgerock.app.condition.GreaterFilter;
import com.forgerock.app.condition.Filter;

import org.junit.BeforeClass;
import org.junit.Test;

public class AndFilterTest {

    private static Map<String, String> user;
    private static EqualsFilter equals;
    private static GreaterFilter greater;

    @BeforeClass
    public static void setUpResource() {
        user = new LinkedHashMap<String, String>();
        user.put("firstname", "Joe");
        user.put("surname", "Bloggs");
        user.put("role", "administrator");
        user.put("age", "35");
    }

    @Test
    public void greaterAndEqualsTrue() {
        greater = new GreaterFilter("age", "30");
        equals = new EqualsFilter("role", "administrator");
        Filter filter = new AndFilter(equals, greater);
        assertTrue(filter.matches(user));
    }

    @Test
    public void greaterFalseEqualsTrue() {
        greater = new GreaterFilter("age", "80");
        equals = new EqualsFilter("role", "administrator");
        Filter filter = new AndFilter(equals, greater);
        assertFalse(filter.matches(user));
    }

    @Test
    public void greaterTrueEqualsFalse() {
        greater = new GreaterFilter("age", "30");
        equals = new EqualsFilter("role", "CEO");
        Filter filter = new AndFilter(equals, greater);
        assertFalse(filter.matches(user));
    }

    @Test
    public void greaterAndEqualsFalse() {
        greater = new GreaterFilter("age", "80");
        equals = new EqualsFilter("role", "CEO");
        Filter filter = new AndFilter(equals, greater);
        assertFalse(filter.matches(user));
    }
}