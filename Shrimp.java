package com.comp301.a01sushi;

public class Shrimp implements Ingredient {
  private final String name = "shrimp";
  private final double pricePerOunce = 0.65;
  private final int caloriesPerOunce = 32;
  private final boolean isVegetarian = false;
  private final boolean hasRice = false;
  private final boolean hasShellfish = true;

  public Shrimp() {}

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getCaloriesPerDollar() {
    return caloriesPerOunce / pricePerOunce;
  }

  @Override
  public int getCaloriesPerOunce() {
    return caloriesPerOunce;
  }

  @Override
  public double getPricePerOunce() {
    return pricePerOunce;
  }

  @Override
  public boolean getIsVegetarian() {
    return isVegetarian;
  }

  @Override
  public boolean getIsRice() {
    return hasRice;
  }

  @Override
  public boolean getIsShellfish() {
    return hasShellfish;
  }

  @Override
  public boolean equals(Ingredient other) {
    if (other == null) return false;
    if (!(other instanceof Shrimp)) return false;
    Shrimp otherShrimp = (Shrimp) other;
    return this.name.equals(otherShrimp.name)
        && this.caloriesPerOunce == otherShrimp.caloriesPerOunce
        && Math.abs(this.pricePerOunce - otherShrimp.pricePerOunce) < 0.01
        && this.isVegetarian == otherShrimp.isVegetarian
        && this.hasRice == otherShrimp.hasRice
        && this.hasShellfish == otherShrimp.hasShellfish;
  }
}
