package com.forgerock.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.forgerock.app.condition.LessFilter;
import com.forgerock.app.condition.Filter;

import org.junit.BeforeClass;
import org.junit.Test;

public class LessFilterTest {

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
    public void ageIsLesser() {
        Filter filter = new LessFilter("age", "40");
        assertTrue(filter.matches(user));
    }

    @Test
    public void ageIsNotLesser() {
        Filter filter = new LessFilter("age", "35");
        assertFalse(filter.matches(user));
    }
}