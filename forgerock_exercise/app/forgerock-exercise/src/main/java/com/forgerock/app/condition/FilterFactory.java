package com.forgerock.app.condition;

  /**
    *  Generates object of concrete Filter class based on given information. Can be: Boolean, Present, Logical and Comparison
    *  
    */
public class FilterFactory {

    public FilterFactory() {
    }

    // Return Boolean Filter class
    public BooleanFilter getBooleanFilter(boolean value) {
        return new BooleanFilter(value);
    }  

    // Return Present Filter class
    public PresentFilter getPresentFilter(String property) {
        return new PresentFilter(property);
    }  

    // Return Logical AND & OR Filter classes
    public Filter getLogical(Logical logical, Filter c1, Filter c2) {
        Filter newFilter;

        switch(logical) {
            case AND:
              newFilter = new AndFilter(c1, c2);
              break;
            case OR:
              newFilter = new OrFilter(c1, c2);
              break;
            default:
              return null;
          }
         return newFilter;
    }

    // Return Not Filter class
    public NotFilter getNotFilter(Filter c1) {
        return new NotFilter(c1);
    }  

    // Return Comparison Filter classes
    public Filter getComparison(Comparison comparison, String property, String value) {
        Filter newCompFilter;

        switch(comparison) {
            case EQUALS:
              newCompFilter = new EqualsFilter(property, value);
              break;
            case GREATER:
              newCompFilter = new GreaterFilter(property, value);
              break;
            case LESS:
              newCompFilter = new LessFilter(property, value);
              break;
            case REGEX:
              newCompFilter = new RegexFilter(property, value);
              break;
            default:
              return null;
          }
         return newCompFilter;
    }
}