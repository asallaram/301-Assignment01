package com.comp301.a01sushi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Roll implements Sushi {
  private final String name;
  private final IngredientPortion[] rollIngredients;

  public Roll(String name, IngredientPortion[] rollIngredients) {
    if (name == null || rollIngredients == null || rollIngredients.length == 0) {
      throw new IllegalArgumentException("Invalid name or ingredients for Roll");
    }

    List<IngredientPortion> combinedIngredients = new ArrayList<>();
    double totalSeaweedAmount = 0.0;

    for (IngredientPortion portion : rollIngredients) {
      if (portion == null) {
        throw new IllegalArgumentException("Ingredient portion cannot be null");
      }

      boolean found = false;

      for (int i = 0; i < combinedIngredients.size(); i++) {
        if (portion.getName().equals(combinedIngredients.get(i).getName())) {
          combinedIngredients.set(i, combinedIngredients.get(i).combine(portion));
          found = true;
          break;
        }
      }

      if (!found) {
        combinedIngredients.add(portion);
      }

      if (portion.getName().equals("seaweed")) {
        totalSeaweedAmount += portion.getAmount();
      }
    }

    double neededSeaweed = 0.1 - totalSeaweedAmount;
    if (neededSeaweed > 0.0) {
      combinedIngredients.add(new SeaweedPortion(neededSeaweed));
    }

    this.name = name;
    this.rollIngredients = combinedIngredients.toArray(new IngredientPortion[0]);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IngredientPortion[] getIngredients() {
    return rollIngredients.clone();
  }

  @Override
  public int getCalories() {
    double totalCalories = 0.0;

    for (IngredientPortion portion : rollIngredients) {
      totalCalories += portion.getCalories();
    }

    return (int) Math.round(totalCalories);
  }

  @Override
  public double getCost() {
    IngredientPortion[] ingredients = getIngredients();
    double cost = 0.0;

    for (IngredientPortion portion : ingredients) {
      cost += portion.getCost();
    }
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    return Double.parseDouble(decimalFormat.format(cost));
  }

  @Override
  public boolean getHasRice() {
    for (IngredientPortion portion : rollIngredients) {
      if (portion.getIsRice()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getHasShellfish() {
    for (IngredientPortion portion : rollIngredients) {
      if (portion.getIsShellfish()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean getIsVegetarian() {
    for (IngredientPortion portion : rollIngredients) {
      if (!portion.getIsVegetarian()) {
        return false;
      }
    }
    return true;
  }
}
