package com.forgerock.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.forgerock.app.condition.BooleanFilter;
import com.forgerock.app.condition.Filter;

import org.junit.BeforeClass;
import org.junit.Test;

public class BooleanFilterTest {

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
    public void firstnameIsEqual() {
        Filter filter = new BooleanFilter(true);
        assertTrue(filter.matches(user));
    }

    @Test
    public void firstnameIsNotEqual() {
        Filter filter = new BooleanFilter(false);
        assertFalse(filter.matches(user));
    }
}