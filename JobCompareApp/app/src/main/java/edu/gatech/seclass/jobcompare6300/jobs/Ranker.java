package edu.gatech.seclass.jobcompare6300.jobs;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.gatech.seclass.jobcompare6300.locations.LocationUtil;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWeights;

public final class Ranker {

  private Ranker() {
  }

  public static List<JobOffer> rank(UserWeights weights, List<JobOffer> offers) {
    return offers.stream()
        .sorted(
            Comparator.<JobOffer>comparingDouble(offer ->
                computeJobOfferScore(weights, offer))
                .reversed())
        .collect(Collectors.toList());
  }

  public static double computeJobOfferScore(UserWeights weights, JobOffer offer) {
    if (offer.getOverallCostOfLiving() <= 0) {
      throw new IllegalArgumentException(
          String.format("Invalid cost of living: %f", offer.getOverallCostOfLiving()));
    }
    double totalWeight =
        weights.getSalaryWeight()
        + weights.getSigningBonusWeight()
        + weights.getYearlyBonusWeight()
        + weights.getRetirementBenefitsWeight()
        + weights.getPtoWeight();

    // Compute cost of living adjusted (cola) salary + bonuses.
    double cola = offer.getOverallCostOfLiving() / LocationUtil.BASELINE_COST_OF_LIVING;
    double adjYearlySalary = offer.getSalary() / cola;
    double adjSigningBonus = offer.getSigningBonus() / cola;
    double adjYearlyBonus = offer.getYearlyBonus() / cola;

    // Compute individual factors.
    double salaryFactor = (weights.getSalaryWeight() / totalWeight) * adjYearlySalary;
    double signingBonusFactor = (weights.getSigningBonusWeight() / totalWeight) * adjSigningBonus;
    double yearlyBonusFactor = (weights.getYearlyBonusWeight() / totalWeight) * adjYearlyBonus;
    double retirementFactor =
        (weights.getRetirementBenefitsWeight() / totalWeight)
        * offer.getRetirementPctMatch() / 100.0
        * adjYearlySalary;
    double ptoFactor =
        (weights.getPtoWeight() / totalWeight)
        * offer.getPtoDays()
        * adjYearlySalary
        / 260;

    return salaryFactor + signingBonusFactor + yearlyBonusFactor + retirementFactor + ptoFactor;
  }
}
