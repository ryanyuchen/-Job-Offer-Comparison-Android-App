package edu.gatech.seclass.jobcompare6300.storage.entities;

public class UserWeights {

  private final int salaryWeight;
  private final int signingBonusWeight;
  private final int yearlyBonusWeight;
  private final int retirementBenefitsWeight;
  private final int ptoWeight;

  public UserWeights(
      int salaryWeight,
      int signingBonusWeight,
      int yearlyBonusWeight,
      int retirementBenefitsWeight,
      int ptoWeight) {
    this.salaryWeight = salaryWeight;
    this.signingBonusWeight = signingBonusWeight;
    this.yearlyBonusWeight = yearlyBonusWeight;
    this.retirementBenefitsWeight = retirementBenefitsWeight;
    this.ptoWeight = ptoWeight;
  }

  public int getSalaryWeight() {
    return salaryWeight;
  }

  public int getSigningBonusWeight() {
    return signingBonusWeight;
  }

  public int getYearlyBonusWeight() {
    return yearlyBonusWeight;
  }

  public int getRetirementBenefitsWeight() {
    return retirementBenefitsWeight;
  }

  public int getPtoWeight() {
    return ptoWeight;
  }

  public static UserWeights defaultInstance() {
    return new UserWeights.Builder().build();
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof UserWeights) {
      UserWeights userWeights = (UserWeights) object;
      return salaryWeight == userWeights.getSalaryWeight()
             && signingBonusWeight == userWeights.getSigningBonusWeight()
             && yearlyBonusWeight == userWeights.getYearlyBonusWeight()
             && retirementBenefitsWeight == userWeights.getRetirementBenefitsWeight()
             && ptoWeight == userWeights.getPtoWeight();
    }
    return false;
  }

  public static class Builder {

    private int salaryWeight;
    private int signingBonusWeight;
    private int yearlyBonusWeight;
    private int retirementBenefitsWeight;
    private int ptoWeight;

    private Builder(
        int salaryWeight,
        int signingBonusWeight,
        int yearlyBonusWeight,
        int retirementBenefitsWeight,
        int ptoWeight) {
      this.salaryWeight = salaryWeight;
      this.signingBonusWeight = signingBonusWeight;
      this.yearlyBonusWeight = yearlyBonusWeight;
      this.retirementBenefitsWeight = retirementBenefitsWeight;
      this.ptoWeight = ptoWeight;
    }

    public Builder() {
      this(1, 1, 1, 1, 1);
    }

    public Builder setSalaryWeight(int salaryWeight) {
      this.salaryWeight = salaryWeight;
      return this;
    }

    public Builder setSigningBonusWeight(int signingBonusWeight) {
      this.signingBonusWeight = signingBonusWeight;
      return this;
    }

    public Builder setYearlyBonusWeight(int yearlyBonusWeight) {
      this.yearlyBonusWeight = yearlyBonusWeight;
      return this;
    }

    public Builder setRetirementBenefitsWeight(int retirementBenefitsWeight) {
      this.retirementBenefitsWeight = retirementBenefitsWeight;
      return this;
    }

    public Builder setPtoWeight(int ptoWeight) {
      this.ptoWeight = ptoWeight;
      return this;
    }

    public UserWeights build() {
      return new UserWeights(
          salaryWeight, signingBonusWeight, yearlyBonusWeight, retirementBenefitsWeight, ptoWeight);
    }
  }
}
