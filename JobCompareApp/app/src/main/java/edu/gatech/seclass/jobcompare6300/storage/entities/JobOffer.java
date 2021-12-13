package edu.gatech.seclass.jobcompare6300.storage.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class JobOffer {

  @PrimaryKey(autoGenerate = true)
  private long jobOfferId;
  private long userId;

  private final String title;
  private final String company;
  private final String location;
  private final double salary;
  private final double signingBonus;
  private final double yearlyBonus;
  private final double retirementPctMatch;
  private final int ptoDays;
  private final double overallCostOfLiving;

  public JobOffer(
      long jobOfferId,
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
    this.jobOfferId = jobOfferId;
    this.userId = userId;
    this.title = title;
    this.company = company;
    this.location = location;
    this.salary = salary;
    this.signingBonus = signingBonus;
    this.yearlyBonus = yearlyBonus;
    this.retirementPctMatch = retirementPctMatch;
    this.ptoDays = ptoDays;
    this.overallCostOfLiving = overallCostOfLiving;
  }

  @Ignore
  private JobOffer(
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
    this.userId = userId;
    this.title = title;
    this.company = company;
    this.location = location;
    this.salary = salary;
    this.signingBonus = signingBonus;
    this.yearlyBonus = yearlyBonus;
    this.retirementPctMatch = retirementPctMatch;
    this.ptoDays = ptoDays;
    this.overallCostOfLiving = overallCostOfLiving;
  }

  public long getJobOfferId() {
    return jobOfferId;
  }

  public long getUserId() {
    return userId;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getLocation() {
    return location;
  }

  public double getSalary() {
    return salary;
  }

  public double getSigningBonus() {
    return signingBonus;
  }

  public double getYearlyBonus() {
    return yearlyBonus;
  }

  public double getRetirementPctMatch() {
    return retirementPctMatch;
  }

  public int getPtoDays() {
    return ptoDays;
  }

  public double getOverallCostOfLiving() {
    return overallCostOfLiving;
  }

  @Ignore
  public Builder toBuilder() {
    return new Builder(
        userId,
        title,
        company,
        location,
        salary,
        signingBonus,
        yearlyBonus,
        retirementPctMatch,
        ptoDays,
        overallCostOfLiving);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof JobOffer) {
      JobOffer jobOffer = (JobOffer) object;
      return userId == jobOffer.getUserId()
             && title.equals(jobOffer.getTitle())
             && company.equals(jobOffer.getCompany())
             && location.equals(jobOffer.getLocation())
             && salary == jobOffer.getSalary()
             && signingBonus == jobOffer.getSigningBonus()
             && yearlyBonus == jobOffer.getYearlyBonus()
             && retirementPctMatch == jobOffer.getRetirementPctMatch()
             && ptoDays == jobOffer.getPtoDays()
             && overallCostOfLiving == jobOffer.getOverallCostOfLiving();
    }
    return false;
  }

  public static class Builder {

    private long userId;
    private String title;
    private String company;
    private String location;
    private double salary;
    private double signingBonus;
    private double yearlyBonus;
    private double retirementPctMatch;
    private int ptoDays;
    private double overallCostOfLiving;

    private Builder(
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
      this.userId = userId;
      this.title = title;
      this.company = company;
      this.location = location;
      this.salary = salary;
      this.signingBonus = signingBonus;
      this.yearlyBonus = yearlyBonus;
      this.retirementPctMatch = retirementPctMatch;
      this.ptoDays = ptoDays;
      this.overallCostOfLiving = overallCostOfLiving;
    }

    public Builder() {
      this(
          -1,
          null,
          null,
          null,
          0,
          0,
          0,
          0,
          0,
          0);
    }

    public Builder setUserId(long userId) {
      this.userId = userId;
      return this;
    }

    public Builder setTitle(@NonNull String title) {
      this.title = title;
      return this;
    }

    public Builder setCompany(@NonNull String company) {
      this.company = company;
      return this;
    }

    public Builder setLocation(@NonNull String location) {
      this.location = location;
      return this;
    }

    public Builder setSalary(double salary) {
      this.salary = salary;
      return this;
    }

    public Builder setSigningBonus(double signingBonus) {
      this.signingBonus = signingBonus;
      return this;
    }

    public Builder setYearlyBonus(double yearlyBonus) {
      this.yearlyBonus = yearlyBonus;
      return this;
    }

    public Builder setRetirementPctMatch(double retirementPctMatch) {
      this.retirementPctMatch = retirementPctMatch;
      return this;
    }

    public Builder setPtoDays(int ptoDays) {
      this.ptoDays = ptoDays;
      return this;
    }

    public Builder setOverallCostOfLiving(double overallCostOfLiving) {
      this.overallCostOfLiving = overallCostOfLiving;
      return this;
    }

    public JobOffer build() {
      if (userId <= 0) {
        throw new IllegalArgumentException(
            String.format("Invalid userId %d, expected it to be >0", userId));
      }
      if (title == null) {
        throw new NullPointerException("title is null");
      }
      if (company == null) {
        throw new NullPointerException("company is null");
      }
      if (location == null) {
        throw new NullPointerException("location is null");
      }
      return new JobOffer(
          userId,
          title,
          company,
          location,
          salary,
          signingBonus,
          yearlyBonus,
          retirementPctMatch,
          ptoDays,
          overallCostOfLiving);
    }
  }
}
