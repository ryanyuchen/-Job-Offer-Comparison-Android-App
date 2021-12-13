package edu.gatech.seclass.jobcompare6300.jobs;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.storage.database.UserDatabase;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWeights;

public class JobManager {

  private final UserDatabase userDatabase;

  public JobManager(UserDatabase database) {
    userDatabase = database;
  }

  public JobOffer createJobOfferForUser(
      User user,
      long userId,
      String title,
      String company,
      String location,
      double salary,
      double signingBonus,
      double yearlyBonus,
      double retirementPctMatch,
      int ptoDays,
      double overallCostOfLiving) {
    JobOffer newOffer = new JobOffer.Builder()
        .setUserId(userId)
        .setTitle(title)
        .setCompany(company)
        .setLocation(location)
        .setSalary(salary)
        .setSigningBonus(signingBonus)
        .setYearlyBonus(yearlyBonus)
        .setRetirementPctMatch(retirementPctMatch)
        .setPtoDays(ptoDays)
        .setOverallCostOfLiving(overallCostOfLiving)
        .build();
    List<JobOffer> offers = userDatabase.userDao().getOffersForUser(user.getUserId());
    offers.add(newOffer);
    userDatabase.userDao().insertOrUpdate(offers);
    userDatabase.userDao().setOffersForUser(user, offers);
    return newOffer;
  }

  public void deleteJobOfferForUser(User user, JobOffer offer) {
    List<JobOffer> offers = userDatabase.userDao().getOffersForUser(user.getUserId());
    offers.remove(offer);
    userDatabase.userDao().setOffersForUser(user, offers);
  }

  public User createUser(
      String name,
      int salaryWeight,
      int signingBonusWeight,
      int yearlyBonusWeight,
      int retirementBenefitsWeight,
      int ptoWeight) {
    UserWeights weights = new UserWeights.Builder()
        .setSalaryWeight(salaryWeight)
        .setSigningBonusWeight(signingBonusWeight)
        .setYearlyBonusWeight(yearlyBonusWeight)
        .setRetirementBenefitsWeight(retirementBenefitsWeight)
        .setPtoWeight(ptoWeight)
        .build();
    User newUser = new User.Builder()
        .setName(name)
        .setUserWeights(weights)
        .build();
    long userId = userDatabase.userDao().insertOrUpdate(newUser);
    return newUser.toBuilder().setUserId(userId).build();
  }

  public void updateUser(
      User user,
      int salaryWeight,
      int signingBonusWeight,
      int yearlyBonusWeight,
      int retirementBenefitsWeight,
      int ptoWeight) {
    UserWeights weights = new UserWeights.Builder()
        .setSalaryWeight(salaryWeight)
        .setSigningBonusWeight(signingBonusWeight)
        .setYearlyBonusWeight(yearlyBonusWeight)
        .setRetirementBenefitsWeight(retirementBenefitsWeight)
        .setPtoWeight(ptoWeight)
        .build();
    User updatedUser = user.toBuilder()
        .setUserWeights(weights)
        .build();
    userDatabase.userDao().insertOrUpdate(updatedUser);
  }
}
