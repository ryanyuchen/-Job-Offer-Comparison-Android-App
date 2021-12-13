package edu.gatech.seclass.jobcompare6300.storage.entities;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Relation;

public class UserWithOffers {

  @Embedded
  private final User user;

  @Relation(parentColumn = "userId", entityColumn = "userId", entity = JobOffer.class)
  private final List<JobOffer> jobOffers;

  public UserWithOffers(User user, List<JobOffer> jobOffers) {
    this.user = user;
    this.jobOffers = jobOffers;
  }

  public User getUser() {
    return user;
  }

  public List<JobOffer> getJobOffers() {
    return new ArrayList<>(jobOffers);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof UserWithOffers) {
      UserWithOffers userWithOffers = (UserWithOffers) object;
      return user.equals(userWithOffers.getUser())
             && jobOffers.equals(userWithOffers.getJobOffers());
    }
    return false;
  }

  public static class Builder {

    private User user;
    private List<JobOffer> jobOffers;

    private Builder(User user, List<JobOffer> jobOffers) {
      this.user = user;
      this.jobOffers = jobOffers;
    }

    public Builder() {
      this(null, null);
    }

    public Builder setUser(@NonNull User user) {
      this.user = user;
      return this;
    }

    public Builder setJobOffers(@NonNull List<JobOffer> jobOffers) {
      // Make a defensive copy.
      this.jobOffers = new ArrayList<>(jobOffers);
      return this;
    }

    public UserWithOffers build() {
      if (user == null) {
        throw new NullPointerException("user is null");
      }
      if (jobOffers == null) {
        throw new NullPointerException("jobOffers is null");
      }
      return new UserWithOffers(user, jobOffers);
    }
  }
}
