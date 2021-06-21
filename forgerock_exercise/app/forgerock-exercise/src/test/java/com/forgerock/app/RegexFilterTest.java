package com.forgerock.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.forgerock.app.condition.RegexFilter;
import com.forgerock.app.condition.Filter;

import org.junit.BeforeClass;
import org.junit.Test;

public class RegexFilterTest {

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
    public void roleRegex() {
        Filter filter = new RegexFilter("role", "admin");
        assertTrue(filter.matches(user));
    }

    @Test
    public void notRoleRegex() {
        Filter filter = new RegexFilter("role", "00");
        assertFalse(filter.matches(user));
    }
}