package edu.gatech.seclass.jobcompare6300.jobs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWeights;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class RankerTest {

  @Test
  public void computeJobOfferScore_defaultWeight() {
    JobOffer offer = new JobOffer.Builder()
        .setUserId(1)
        .setTitle("Software Engineer")
        .setCompany("Foo Inc.")
        .setLocation("Boston, MA")
        .setSalary(10000)
        .setSigningBonus(10000)
        .setYearlyBonus(10000)
        .setRetirementPctMatch(10)
        .setPtoDays(10)
        .setOverallCostOfLiving(100)
        .build();
    UserWeights weights = UserWeights.defaultInstance();
    // (1/5)*10K + (1/5)*10K + (1/5)*10K + (1/5)*((10/100)*10K) + (1/5)*(10*10K/260)
    double expected = 6276.923;
    assertThat(Ranker.computeJobOfferScore(weights, offer)).isWithin(0.001).of(expected);
  }

  @Test
  public void computeJobOfferScore_naughtJobOffer() {
    JobOffer offer = new JobOffer.Builder()
        .setUserId(1)
        .setTitle("Software Engineer")
        .setCompany("Foo Inc.")
        .setLocation("Boston, MA")
        .setSalary(0)
        .setSigningBonus(0)
        .setYearlyBonus(0)
        .setRetirementPctMatch(0)
        .setPtoDays(0)
        .setOverallCostOfLiving(1)
        .build();
    UserWeights weights = UserWeights.defaultInstance();
    assertThat(Ranker.computeJobOfferScore(weights, offer)).isEqualTo(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void computeJobOfferScore_badOffer() {
    JobOffer offer = new JobOffer.Builder()
        .setUserId(1)
        .setTitle("Software Engineer")
        .setCompany("Foo Inc.")
        .setLocation("Boston, MA")
        .setSalary(0)
        .setSigningBonus(0)
        .setYearlyBonus(0)
        .setRetirementPctMatch(0)
        .setPtoDays(0)
        .setOverallCostOfLiving(0)
        .build();
    UserWeights weights = UserWeights.defaultInstance();
    Ranker.computeJobOfferScore(weights, offer);
  }

  @Test
  public void computeJobOfferScore_nonDefaultWeights() {
    JobOffer offer = new JobOffer.Builder()
        .setUserId(1)
        .setTitle("Software Engineer")
        .setCompany("Foo Inc.")
        .setLocation("Boston, MA")
        .setSalary(10000)
        .setSigningBonus(10000)
        .setYearlyBonus(10000)
        .setRetirementPctMatch(10)
        .setPtoDays(10)
        .setOverallCostOfLiving(100)
        .build();
    UserWeights weights = new UserWeights.Builder()
        .setSalaryWeight(2)
        .setRetirementBenefitsWeight(2)
        .build();
    // (2/7)*10K + (1/7)*10K + (1/7)*10K + (2/7)*((10/100)*10K) + (1/7)*(10*10K/260)
    double expected = 6054.945;
    assertThat(Ranker.computeJobOfferScore(weights, offer)).isWithin(0.001).of(expected);
  }
}
