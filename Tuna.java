package com.comp301.a01sushi;

public class Tuna implements Ingredient {
  private final String name = "tuna";
  private final double pricePerOunce = 1.67;
  private final int caloriesPerOunce = 42;
  private final boolean isVegetarian = false;
  private final boolean hasRice = false;
  private final boolean hasShellfish = false;

  public Tuna() {}

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
    if (!(other instanceof Tuna)) return false;
    Tuna otherTuna = (Tuna) other;
    return this.name.equals(otherTuna.name)
        && this.caloriesPerOunce == otherTuna.caloriesPerOunce
        && Math.abs(this.pricePerOunce - otherTuna.pricePerOunce) < 0.01
        && this.isVegetarian == otherTuna.isVegetarian
        && this.hasRice == otherTuna.hasRice
        && this.hasShellfish == otherTuna.hasShellfish;
  }
}
