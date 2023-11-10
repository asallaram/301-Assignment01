package com.comp301.a01sushi;

public class Yellowtail implements Ingredient {
  private final String name = "yellowtail";
  private final double pricePerOunce = 0.74;
  private final int caloriesPerOunce = 57;
  private final boolean isVegetarian = false;
  private final boolean hasRice = false;
  private final boolean hasShellfish = false;

  public Yellowtail() {}

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
    if (!(other instanceof Yellowtail)) return false;
    Yellowtail otherYellowtail = (Yellowtail) other;
    return this.name.equals(otherYellowtail.name)
        && this.caloriesPerOunce == otherYellowtail.caloriesPerOunce
        && Math.abs(this.pricePerOunce - otherYellowtail.pricePerOunce) < 0.01
        && this.isVegetarian == otherYellowtail.isVegetarian
        && this.hasRice == otherYellowtail.hasRice
        && this.hasShellfish == otherYellowtail.hasShellfish;
  }
}
