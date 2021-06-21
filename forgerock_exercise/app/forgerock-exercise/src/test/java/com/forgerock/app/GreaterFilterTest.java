package com.forgerock.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.forgerock.app.condition.GreaterFilter;
import com.forgerock.app.condition.Filter;

import org.junit.BeforeClass;
import org.junit.Test;

public class GreaterFilterTest {

    private static Map<String, String> user;

    @BeforeClass
    public static void setUpResource() {
        user = new LinkedHashMap<String, String>();
        user.put("firstname", "Joe");
        user.put("surname", "Bloggs");
        user.put("role", "administrator");
        user.put("age", "35");
    }

    @Test
    public void ageIsGreater() {
        Filter filter = new GreaterFilter("age", "30");
        assertTrue(filter.matches(user));
    }

    @Test
    public void ageIsNotGreater() {
        Filter filter = new GreaterFilter("age", "35");
        assertFalse(filter.matches(user));
    }
}