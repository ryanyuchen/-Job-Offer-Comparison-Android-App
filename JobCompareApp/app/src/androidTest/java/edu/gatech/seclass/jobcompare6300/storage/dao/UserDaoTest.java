package edu.gatech.seclass.jobcompare6300.storage.dao;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import edu.gatech.seclass.jobcompare6300.storage.database.UserDatabase;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWeights;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWithOffers;

import static com.google.common.truth.Truth.assertThat;

@RunWith(AndroidJUnit4.class)
public class UserDaoTest {

  private static final User USER =
      new User.Builder()
          .setName("John Doe")
          .setUserWeights(new UserWeights.Builder().build())
          .build();

  private UserDatabase userDatabase;
  private UserDao userDao;

  @Before
  public void setUp() {
    Context context = ApplicationProvider.getApplicationContext();
    userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();
    userDao = userDatabase.userDao();
  }

  @After
  public void cleanUp() {
    userDatabase.close();
  }

  @Test
  public void getAllUsersWhenEmpty() {
    assertThat(userDao.getAllUsers()).isEmpty();
  }

  @Test
  public void addSingleUser() {
    userDao.insertOrUpdate(USER);
    List<UserWithOffers> usersWithOffers = userDao.getAllUsers();
    assertThat(usersWithOffers).hasSize(1);
    assertThat(usersWithOffers.get(0).getJobOffers()).isEmpty();
  }

  @Test
  public void addMultipleUsers() {
    userDao.insertOrUpdate(USER);
    userDao.insertOrUpdate(USER);
    List<UserWithOffers> usersWithOffers = userDao.getAllUsers();
    assertThat(usersWithOffers).hasSize(2);
    assertThat(usersWithOffers.get(0)).isNotSameInstanceAs(usersWithOffers.get(1));
    assertThat(usersWithOffers.get(0).getUser().getUserId())
        .isNotEqualTo(usersWithOffers.get(1).getUser().getUserId());
  }

  @Test
  public void updateUser() {
    userDao.insertOrUpdate(USER);

    List<UserWithOffers> usersWithOffers = userDao.getAllUsers();
    User user = usersWithOffers.get(0).getUser();

    assertThat(usersWithOffers).hasSize(1);
    assertThat(usersWithOffers.get(0).getJobOffers()).isEmpty();

    List<JobOffer> offers = new ArrayList<>();
    JobOffer offer = new JobOffer.Builder()
        .setUserId(user.getUserId())
        .setTitle("Software Engineer")
        .setCompany("Foo Inc.")
        .setLocation("Boston, MA")
        .setSalary(100000)
        .setSigningBonus(20000)
        .setYearlyBonus(15000)
        .setRetirementPctMatch(3)
        .setPtoDays(15)
        .setOverallCostOfLiving(100)
        .build();
    offers.add(offer);

    userDao.setOffersForUser(user, offers);

    usersWithOffers = userDao.getAllUsers();
    assertThat(usersWithOffers).hasSize(1);
    assertThat(usersWithOffers.get(0).getJobOffers()).containsExactly(offer);
  }

  @Test
  public void getUserById() {
    long userId = userDao.insertOrUpdate(USER);
    User expected = USER.toBuilder().setUserId(userId).build();
    assertThat(userDao.getUserById(userId)).isEqualTo(expected);
  }

  @Test
  public void deleteUserAndOffers() {
    long userId = userDao.insertOrUpdate(USER);
    JobOffer offer = new JobOffer.Builder()
        .setUserId(userId)
        .setTitle("Software Engineer")
        .setCompany("Foo Inc.")
        .setLocation("Boston, MA")
        .setSalary(100000)
        .setSigningBonus(20000)
        .setYearlyBonus(15000)
        .setRetirementPctMatch(3)
        .setPtoDays(15)
        .setOverallCostOfLiving(100)
        .build();
    userDao.insertOrUpdate(offer);
    assertThat(userDao.getAllUsers()).hasSize(1);
    List<JobOffer> offers = userDao.getOffersForUser(userId);
    assertThat(offers).hasSize(1);
    userDao.deleteUserWithOffers(userId);
    assertThat(userDao.getAllUsers()).isEmpty();
    assertThat(userDao.getOffersForUser(userId)).isEmpty();
  }
}
