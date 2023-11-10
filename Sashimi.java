package com.comp301.a01sushi;

public class Sashimi implements Sushi {
  private final SashimiType type;

  public Sashimi(SashimiType type) {
    this.type = type;
  }

  @Override
  public String getName() {
    String typeName = "";
    if (type == SashimiType.TUNA) {
      typeName = "tuna";
    } else if (type == SashimiType.YELLOWTAIL) {
      typeName = "yellowtail";
    } else if (type == SashimiType.EEL) {
      typeName = "eel";
    } else if (type == SashimiType.CRAB) {
      typeName = "crab";
    } else if (type == SashimiType.SHRIMP) {
      typeName = "shrimp";
    }
    return typeName + " sashimi";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] ingredients = new IngredientPortion[1];
    double portionAmount = 0.75;

    if (type == SashimiType.TUNA) {
      ingredients[0] = new TunaPortion(portionAmount);
    } else if (type == SashimiType.YELLOWTAIL) {
      ingredients[0] = new YellowtailPortion(portionAmount);
    } else if (type == SashimiType.EEL) {
      ingredients[0] = new EelPortion(portionAmount);
    } else if (type == SashimiType.CRAB) {
      ingredients[0] = new CrabPortion(portionAmount);
    } else if (type == SashimiType.SHRIMP) {
      ingredients[0] = new ShrimpPortion(portionAmount);
    }

    return ingredients;
  }

  @Override
  public int getCalories() {
    IngredientPortion[] ingredients = getIngredients();
    double calories = 0.0;
    for (IngredientPortion portion : ingredients) {
      calories += portion.getCalories();
    }

    return (int) Math.round(calories);
  }

  @Override
  public double getCost() {
    IngredientPortion[] ingredients = getIngredients();
    double cost = 0.0;
    for (IngredientPortion portion : ingredients) {
      cost += portion.getCost();
    }
    return cost;
  }

  @Override
  public boolean getHasRice() {
    return false; // Sashimi doesn't have rice
  }

  @Override
  public boolean getHasShellfish() {
    IngredientPortion[] ingredients = getIngredients();
    for (IngredientPortion portion : ingredients) {
      if (portion.getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    return false; // Sashimi is not vegetarian
  }

  public enum SashimiType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
