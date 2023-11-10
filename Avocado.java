package com.comp301.a01sushi;

public class Avocado implements Ingredient {
  private final String name = "avocado";
  private final double pricePerOunce = 0.24;
  private final int caloriesPerOunce = 42;
  private final boolean isVegetarian = true;
  private final boolean hasRice = false;
  private final boolean hasShellfish = false;

  public Avocado() {}

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
    if (!(other instanceof Avocado)) return false;
    Avocado otherAvocado = (Avocado) other;
    return this.name.equals(otherAvocado.name)
        && this.caloriesPerOunce == otherAvocado.caloriesPerOunce
        && Math.abs(this.pricePerOunce - otherAvocado.pricePerOunce) < 0.01
        && this.isVegetarian == otherAvocado.isVegetarian
        && this.hasRice == otherAvocado.hasRice
        && this.hasShellfish == otherAvocado.hasShellfish;
  }
}
