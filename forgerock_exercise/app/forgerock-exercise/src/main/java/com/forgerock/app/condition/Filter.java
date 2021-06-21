package com.forgerock.app.condition;

import java.util.*;
  /**
    * Interface cointaning the match function
    */
public interface Filter {

    public boolean matches(Map <String, String> resource);
}