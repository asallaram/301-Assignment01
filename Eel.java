package com.comp301.a01sushi;

public class Eel implements Ingredient {
  private final String name = "eel";
  private final double pricePerOunce = 2.15;
  private final int caloriesPerOunce = 82;
  private final boolean isVegetarian = false;
  private final boolean hasRice = false;
  private final boolean hasShellfish = false;

  public Eel() {}

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
    if (!(other instanceof Eel)) return false;
    Eel otherEel = (Eel) other;
    return this.name.equals(otherEel.name)
        && this.caloriesPerOunce == otherEel.caloriesPerOunce
        && Math.abs(this.pricePerOunce - otherEel.pricePerOunce) < 0.01
        && this.isVegetarian == otherEel.isVegetarian
        && this.hasRice == otherEel.hasRice
        && this.hasShellfish == otherEel.hasShellfish;
  }
}
