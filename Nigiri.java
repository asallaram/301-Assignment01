package com.comp301.a01sushi;

public class Nigiri implements Sushi {
  private final NigiriType type;

  public Nigiri(NigiriType type) {
    this.type = type;
  }

  @Override
  public String getName() {
    String typeName = "";
    if (type == NigiriType.TUNA) {
      typeName = "tuna";
    } else if (type == NigiriType.YELLOWTAIL) {
      typeName = "yellowtail";
    } else if (type == NigiriType.EEL) {
      typeName = "eel";
    } else if (type == NigiriType.CRAB) {
      typeName = "crab";
    } else if (type == NigiriType.SHRIMP) {
      typeName = "shrimp";
    }
    return typeName + " nigiri";
  }

  @Override
  public IngredientPortion[] getIngredients() {
    IngredientPortion[] ingredients = new IngredientPortion[2];
    double seafoodPortionAmount = 0.75;
    double ricePortionAmount = 0.5;

    if (type == NigiriType.TUNA) {
      ingredients[0] = new TunaPortion(seafoodPortionAmount);
    } else if (type == NigiriType.YELLOWTAIL) {
      ingredients[0] = new YellowtailPortion(seafoodPortionAmount);
    } else if (type == NigiriType.EEL) {
      ingredients[0] = new EelPortion(seafoodPortionAmount);
    } else if (type == NigiriType.CRAB) {
      ingredients[0] = new CrabPortion(seafoodPortionAmount);
    } else if (type == NigiriType.SHRIMP) {
      ingredients[0] = new ShrimpPortion(seafoodPortionAmount);
    }

    ingredients[1] = new RicePortion(ricePortionAmount);

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
    return true;
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
    return false;
  }

  public enum NigiriType {
    TUNA,
    YELLOWTAIL,
    EEL,
    CRAB,
    SHRIMP
  }
}
