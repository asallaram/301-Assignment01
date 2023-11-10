package com.comp301.a01sushi;

public class Crab implements Ingredient {
  private final String name = "crab";
  private final double pricePerOunce = 0.72;
  private final int caloriesPerOunce = 37;
  private final boolean isVegetarian = false;
  private final boolean hasRice = false;
  private final boolean hasShellfish = true;

  public Crab() {}

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
    if (!(other instanceof Crab)) return false;
    Crab otherCrab = (Crab) other;
    return this.name.equals(otherCrab.name)
        && this.caloriesPerOunce == otherCrab.caloriesPerOunce
        && Math.abs(this.pricePerOunce - otherCrab.pricePerOunce) < 0.01
        && this.isVegetarian == otherCrab.isVegetarian
        && this.hasRice == otherCrab.hasRice
        && this.hasShellfish == otherCrab.hasShellfish;
  }
}
