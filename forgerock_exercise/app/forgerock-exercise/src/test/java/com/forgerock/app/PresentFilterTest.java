package com.forgerock.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.forgerock.app.condition.Filter;
import com.forgerock.app.condition.PresentFilter;

import org.junit.BeforeClass;
import org.junit.Test;

public class PresentFilterTest {

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
    public void roleIsPresent() {
        Filter filter = new PresentFilter("role");
        assertTrue(filter.matches(user));
    }

    @Test
    public void roleNotCapital() {
        Filter filter = new PresentFilter("Role");
        assertFalse(filter.matches(user));
    }
}