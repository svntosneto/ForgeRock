package com.forgerock.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;

import com.forgerock.app.condition.NotFilter;
import com.forgerock.app.condition.EqualsFilter;
import com.forgerock.app.condition.Filter;

import org.junit.BeforeClass;
import org.junit.Test;

public class NotFilterTest {

    private static Map<String, String> user;
    private static EqualsFilter equals;
    private static EqualsFilter notEquals;

    @BeforeClass
    public static void setUpResource() {
        user = new LinkedHashMap<String, String>();
        user.put("firstname", "Joe");
        user.put("surname", "Bloggs");
        user.put("role", "administrator");
        user.put("age", "35");
    }

    @BeforeClass
    public static void setUpFilter() {
        notEquals = new EqualsFilter("surname", "Neto");
        equals = new EqualsFilter("surname", "Bloggs");
    }

    @Test
    public void surnameIsNot() {
        Filter filter = new NotFilter(notEquals);
        assertTrue(filter.matches(user));
    }

    @Test
    public void surnameIsNotEqual() {
        Filter filter = new NotFilter(equals);
        assertFalse(filter.matches(user));
    }
}