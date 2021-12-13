package edu.gatech.seclass.jobcompare6300.storage.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWithOffers;

@Dao
public abstract class UserDao {

  @Transaction
  @Query("SELECT * from User")
  abstract List<UserWithOffers> getAllUsers();

  @Transaction
  @Query("SELECT * from User")
  public abstract List<User> getUsers();

  @Transaction
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  abstract long insertUser(User user);

  @Transaction
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  abstract List<Long> insertJobOffers(List<JobOffer> jobOffers);

  @Transaction
  @Update
  abstract void updateUser(User user);

  @Transaction
  @Update
  abstract void updateJobOffers(List<JobOffer> jobOffers);

  @Transaction
  @Delete
  public abstract void deleteOffer(JobOffer offer);

  /**
   * Deletes all {@link JobOffer}s for {@code userId}.
   * @param userId to delete {@link JobOffer}s for.
   */
  @Transaction
  @Query("DELETE FROM JobOffer WHERE userId = :userId")
  public abstract void deleteOffersForUserId(long userId);

  @Transaction
  public void setOffersForUser(User user, List<JobOffer> offers) {
    // Clear existing offers.
    deleteOffersForUserId(user.getUserId());
    // Ensure that all offers have a userId set.
    List<JobOffer> toInsert = new ArrayList<>(offers.size());
    for (JobOffer offer : offers) {
      toInsert.add(offer.toBuilder().setUserId(user.getUserId()).build());
    }
    insertOrUpdate(toInsert);
  }

  @Transaction
  @Query("SELECT * FROM JobOffer WHERE userId = :userId")
  public abstract List<JobOffer> getOffersForUser(long userId);

  @Transaction
  @Query("DELETE FROM User WHERE userId = :userId")
  abstract void deleteUserById(long userId);

  @Transaction
  public void deleteUserWithOffers(long userId) {
    deleteOffersForUserId(userId);
    deleteUserById(userId);
  }

  @Transaction
  @Query("SELECT * FROM User WHERE userId = :userId")
  public abstract User getUserById(long userId);

  @Transaction
  public long insertOrUpdate(User user) {
    long id = insertUser(user);
    if (id == -1) { // User already exists.
      updateUser(user); // Update them.
      return user.getUserId();
    }
    return id;
  }

  @Transaction
  public void insertOrUpdate(JobOffer jobOffer) {
    insertOrUpdate(Collections.singletonList(jobOffer));
  }

  @Transaction
  public void insertOrUpdate(List<JobOffer> jobOffers) {
    List<Long> insertResult = insertJobOffers(jobOffers);
    List<JobOffer> toUpdate = new ArrayList<>();
    for (int i = 0; i < insertResult.size() && i < jobOffers.size(); i++) {
      if (insertResult.get(i) == -1) {
        toUpdate.add(jobOffers.get(i));
      }
    }
    if (!toUpdate.isEmpty()) {
      updateJobOffers(toUpdate);
    }
  }
}
