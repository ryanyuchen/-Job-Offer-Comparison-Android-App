package edu.gatech.seclass.jobcompare6300.storage.entities;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {

  private final String name;
  @Embedded
  private final UserWeights userWeights;
  @PrimaryKey(autoGenerate = true)
  private long userId;

  public User(long userId, String name, UserWeights userWeights) {
    if (userId > 0) {
      this.userId = userId;
    }
    this.name = name;
    this.userWeights = userWeights;
  }

  @Ignore
  public Builder toBuilder() {
    return new Builder(userId, name, userWeights);
  }

  public String getName() {
    return name;
  }

  public long getUserId() {
    return userId;
  }

  public UserWeights getUserWeights() {
    return userWeights;
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof User) {
      User user = (User) object;
      return userId == user.getUserId() && userWeights.equals(user.userWeights);
    }
    return false;
  }

  /**
   * Callers shouldn't be modifying the {@link User} directly. Use this {@link Builder} instead.
   */
  public static class Builder {

    private long userId;
    private String name;
    private UserWeights userWeights;

    private Builder(long userId, String name, UserWeights userWeights) {
      this.userId = userId;
      this.name = name;
      this.userWeights = userWeights;
    }

    public Builder() {
      this(-1, null, null);
    }

    /**
     * DO NOT CALL OUTSIDE OF TESTS
     */
    @VisibleForTesting
    public Builder setUserId(long userId) {
      this.userId = userId;
      return this;
    }

    public Builder setName(@NonNull String name) {
      this.name = name;
      return this;
    }

    public Builder setUserWeights(@NonNull UserWeights userWeights) {
      this.userWeights = userWeights;
      return this;
    }

    /**
     * May throw a NPE if fields are not initialized.
     */
    public User build() {
      if (name == null) {
        throw new NullPointerException("name was null");
      }
      if (userWeights == null) {
        throw new NullPointerException("userWeights was null");
      }
      return new User(userId, name, userWeights);
    }
  }
}
