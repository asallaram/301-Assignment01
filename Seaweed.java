package com.comp301.a01sushi;

public class Seaweed implements Ingredient {
  private final String name = "seaweed";
  private final double pricePerOunce = 2.85;
  private final int caloriesPerOunce = 105;
  private final boolean isVegetarian = true;
  private final boolean hasRice = false;
  private final boolean hasShellfish = false;

  public Seaweed() {}

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
    if (!(other instanceof Seaweed)) return false;
    Seaweed otherSeaweed = (Seaweed) other;
    return this.name.equals(otherSeaweed.name)
        && this.caloriesPerOunce == otherSeaweed.caloriesPerOunce
        && Math.abs(this.pricePerOunce - otherSeaweed.pricePerOunce) < 0.01
        && this.isVegetarian == otherSeaweed.isVegetarian
        && this.hasRice == otherSeaweed.hasRice
        && this.hasShellfish == otherSeaweed.hasShellfish;
  }
}
