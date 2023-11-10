package com.comp301.a01sushi;

public class Rice implements Ingredient {
  private final String name = "rice";
  private final double pricePerOunce = 0.13;
  private final int caloriesPerOunce = 34;
  private final boolean isVegetarian = true;
  private final boolean hasRice = true;
  private final boolean hasShellfish = false;

  public Rice() {}

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
    if (!(other instanceof Rice)) return false;
    Rice otherRice = (Rice) other;
    return this.name.equals(otherRice.name)
        && this.caloriesPerOunce == otherRice.caloriesPerOunce
        && Math.abs(this.pricePerOunce - otherRice.pricePerOunce) < 0.01
        && this.isVegetarian == otherRice.isVegetarian
        && this.hasRice == otherRice.hasRice
        && this.hasShellfish == otherRice.hasShellfish;
  }
}
