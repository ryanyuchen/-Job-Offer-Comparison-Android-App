package edu.gatech.seclass.jobcompare6300;

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

import edu.gatech.seclass.jobcompare6300.jobs.JobComparer;
import edu.gatech.seclass.jobcompare6300.jobs.JobManager;
import edu.gatech.seclass.jobcompare6300.jobs.Ranker;
import edu.gatech.seclass.jobcompare6300.storage.dao.UserDao;
import edu.gatech.seclass.jobcompare6300.storage.database.UserDatabase;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWeights;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWithOffers;
import edu.gatech.seclass.jobcompare6300.locations.LocationUtil;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class TestCases {

    private static final User USER =
            new User.Builder()
                    .setName("Tom Brady")
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
    public void AddUserWeight1() {
        UserWeights weights = new UserWeights.Builder()
                .setSalaryWeight(5)
                .setSigningBonusWeight(2)
                .setYearlyBonusWeight(1)
                .setRetirementBenefitsWeight(1)
                .setPtoWeight(1)
                .build();

        User newUser = new User.Builder()
                .setName("Edelman")
                .setUserWeights(weights).build();
        userDao.insertOrUpdate(newUser);

        User actualuser = userDao.getUsers().get(0);

        assertEquals(5, actualuser.getUserWeights().getSalaryWeight());
        assertEquals(2, actualuser.getUserWeights().getSigningBonusWeight());
        assertEquals(1, actualuser.getUserWeights().getYearlyBonusWeight());
        assertEquals(1, actualuser.getUserWeights().getRetirementBenefitsWeight());
        assertEquals(1, actualuser.getUserWeights().getPtoWeight());
    }

    @Test
    public void AddOfferEmptySalary1() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.BOSTON_MA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);


        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(0.0, actualoffer.getSalary(), 0.0001);
    }

    @Test
    public void AddOfferEmptySigningBonus1() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.BOSTON_MA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(0.0, actualoffer.getSigningBonus(), 0.0001);
    }

    @Test
    public void AddOfferEmptyYearlyBonus1() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.BOSTON_MA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setSigningBonus(20000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(0.0, actualoffer.getYearlyBonus(), 0.0001);
    }

    @Test
    public void AddOfferEmptyRetirement1() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.BOSTON_MA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary((100000))
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(0.0, actualoffer.getRetirementPctMatch(), 0.0001);
    }

    @Test
    public void AddOfferEmptyPTO1() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.BOSTON_MA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(0.0, actualoffer.getPtoDays(), 0.0001);
    }

    @Test
    public void AddOfferCheckCoL1() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.BOSTON_MA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(80.46, actualoffer.getOverallCostOfLiving(), 0.0001);
    }

    @Test
    public void AddOfferCheckCoL2() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.NEW_YORK_NY_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(100, actualoffer.getOverallCostOfLiving(), 0.0001);
    }

    @Test
    public void AddOfferCheckCoL3() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.TAMPA_FL_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(68.61, actualoffer.getOverallCostOfLiving(), 0.0001);
    }

    @Test
    public void AddOfferCheckCoL4() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.SAN_FRANCISCO_CA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(96.88, actualoffer.getOverallCostOfLiving(), 0.0001);
    }

    @Test
    public void AddOfferCheckCoL5() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.LOS_ANGELES_CA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals(77.66, actualoffer.getOverallCostOfLiving(), 0.0001);
    }

    @Test
    public void CheckAddOfferAll() {
        userDao.insertOrUpdate(USER);
        User user = userDao.getUsers().get(0);
        LocationUtil.Location location = LocationUtil.Location.BOSTON_MA_UNITED_STATES;

        List<JobOffer> offers = new ArrayList<>();
        JobOffer offer = new JobOffer.Builder()
                .setUserId(user.getUserId())
                .setTitle("Software Engineer")
                .setCompany("Foo Inc.")
                .setLocation(location.getName())
                .setSalary(100000)
                .setSigningBonus(20000)
                .setYearlyBonus(15000)
                .setRetirementPctMatch(3)
                .setPtoDays(15)
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();
        offers.add(offer);
        userDao.setOffersForUser(user, offers);

        User actualuser = userDao.getUsers().get(0);
        JobOffer actualoffer = userDao.getOffersForUser(actualuser.getUserId()).get(0);
        assertEquals("Software Engineer", actualoffer.getTitle());
        assertEquals("Foo Inc.", actualoffer.getCompany());
        assertEquals("Boston, MA, United States", actualoffer.getLocation());
        assertEquals(100000, actualoffer.getSalary(), 0.0001);
        assertEquals(20000, actualoffer.getSigningBonus(), 0.0001);
        assertEquals(15000, actualoffer.getYearlyBonus(), 0.0001);
        assertEquals(3, actualoffer.getRetirementPctMatch(), 0.0001);
        assertEquals(15, actualoffer.getPtoDays(), 0.0001);
        assertEquals(80.46, actualoffer.getOverallCostOfLiving(), 0.0001);

    }

    // The Details of Test Cases are in TestPlan.md
    @Test
    public void JobComparerTest1() {

        Context context = ApplicationProvider.getApplicationContext();
        UserDatabase userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();

        JobManager manager = new JobManager(userDatabase);
        LocationUtil.Location location1 = LocationUtil.Location.BOSTON_MA_UNITED_STATES;
        LocationUtil.Location location2 = LocationUtil.Location.NEW_YORK_NY_UNITED_STATES;

        User newUser = manager.createUser("Tom", 5, 3, 1, 1, 1);
        JobOffer offer1 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer1", "JobOffer1", location1.getName(), 120000, 10000, 12000, 5, 15, location1.getCostOfLiving());
        JobOffer offer2 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer2", "JobOffer2", location2.getName(), 150000, 20000, 20000, 5, 15, location2.getCostOfLiving());
        ArrayList<JobOffer> offers = new ArrayList<JobOffer>();
        offers.add(offer1);
        offers.add(offer2);

        JobComparer comparer = new JobComparer(newUser.getUserWeights(), offers, new ArrayList<JobOffer>());
        comparer.selectJob(0);
        comparer.selectJob(1);

        List<JobOffer> rankedOffers = comparer.rankSelectedJobOffers();
        List<JobOffer> expectedList = new ArrayList<JobOffer>();
        expectedList.add(offer2);
        expectedList.add(offer1);

        assertEquals(rankedOffers, expectedList);
    }

    @Test
    public void JobComparerTest2() {

        Context context = ApplicationProvider.getApplicationContext();
        UserDatabase userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();

        JobManager manager = new JobManager(userDatabase);
        LocationUtil.Location location1 = LocationUtil.Location.SAN_FRANCISCO_CA_UNITED_STATES;
        LocationUtil.Location location2 = LocationUtil.Location.NEW_YORK_NY_UNITED_STATES;

        User newUser = manager.createUser("Tom", 5, 3, 2, 1, 1);
        JobOffer offer1 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer1", "JobOffer1", location1.getName(), 150000, 10000, 12000, 5, 15, location1.getCostOfLiving());
        JobOffer offer2 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer2", "JobOffer2", location2.getName(), 150000, 20000, 20000, 5, 15, location2.getCostOfLiving());
        ArrayList<JobOffer> offers = new ArrayList<JobOffer>();
        offers.add(offer1);
        offers.add(offer2);

        JobComparer comparer = new JobComparer(newUser.getUserWeights(), offers, new ArrayList<JobOffer>());
        comparer.selectJob(0);
        comparer.selectJob(1);

        List<JobOffer> rankedOffers = comparer.rankSelectedJobOffers();
        List<JobOffer> expectedList = new ArrayList<JobOffer>();
        expectedList.add(offer2);
        expectedList.add(offer1);

        assertEquals(rankedOffers, expectedList);
    }

    @Test
    public void JobComparerTest3() {

        Context context = ApplicationProvider.getApplicationContext();
        UserDatabase userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();

        JobManager manager = new JobManager(userDatabase);
        LocationUtil.Location location1 = LocationUtil.Location.BOSTON_MA_UNITED_STATES;
        LocationUtil.Location location2 = LocationUtil.Location.NEW_YORK_NY_UNITED_STATES;

        User newUser = manager.createUser("Tom", 5, 2, 1, 1, 1);
        JobOffer offer1 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer1", "JobOffer1", location1.getName(), 120000, 10000, 12000, 10, 15, location1.getCostOfLiving());
        JobOffer offer2 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer2", "JobOffer2", location2.getName(), 150000, 20000, 20000, 5, 15, location2.getCostOfLiving());
        ArrayList<JobOffer> offers = new ArrayList<JobOffer>();
        offers.add(offer1);
        offers.add(offer2);

        JobComparer comparer = new JobComparer(newUser.getUserWeights(), offers, new ArrayList<JobOffer>());
        comparer.selectJob(0);
        comparer.selectJob(1);

        List<JobOffer> rankedOffers = comparer.rankSelectedJobOffers();
        List<JobOffer> expectedList = new ArrayList<JobOffer>();
        expectedList.add(offer2);
        expectedList.add(offer1);

        assertEquals(rankedOffers, expectedList);
    }

    @Test
    public void JobComparerTest4() {

        Context context = ApplicationProvider.getApplicationContext();
        UserDatabase userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();

        JobManager manager = new JobManager(userDatabase);
        LocationUtil.Location location1 = LocationUtil.Location.LOS_ANGELES_CA_UNITED_STATES;
        LocationUtil.Location location2 = LocationUtil.Location.NEW_YORK_NY_UNITED_STATES;

        User newUser = manager.createUser("Tom", 5, 4, 3, 2, 1);
        JobOffer offer1 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer1", "JobOffer1", location1.getName(), 120000, 10000, 12000, 10, 20, location1.getCostOfLiving());
        JobOffer offer2 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer2", "JobOffer2", location2.getName(), 150000, 20000, 20000, 5, 15, location2.getCostOfLiving());
        ArrayList<JobOffer> offers = new ArrayList<JobOffer>();
        offers.add(offer1);
        offers.add(offer2);

        JobComparer comparer = new JobComparer(newUser.getUserWeights(), offers, new ArrayList<JobOffer>());
        comparer.selectJob(0);
        comparer.selectJob(1);

        List<JobOffer> rankedOffers = comparer.rankSelectedJobOffers();
        List<JobOffer> expectedList = new ArrayList<JobOffer>();
        expectedList.add(offer2);
        expectedList.add(offer1);

        assertEquals(rankedOffers, expectedList);
    }

    @Test
    public void ComputeScoreTest1(){

        Context context = ApplicationProvider.getApplicationContext();
        UserDatabase userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();

        JobManager manager = new JobManager(userDatabase);
        LocationUtil.Location location1 = LocationUtil.Location.SAN_FRANCISCO_CA_UNITED_STATES;

        User newUser = manager.createUser("Tom", 5, 3, 2, 1, 1);
        JobOffer offer1 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer1", "JobOffer1", location1.getName(), 150000, 10000, 12000, 5, 15, location1.getCostOfLiving());
        double score = Ranker.computeJobOfferScore(newUser.getUserWeights(),offer1);

        assertEquals(score, 70547.22,.01);
    }

    @Test
    public void ComputeScoreTest2(){
        Context context = ApplicationProvider.getApplicationContext();
        UserDatabase userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();

        JobManager manager = new JobManager(userDatabase);
        LocationUtil.Location location2 = LocationUtil.Location.NEW_YORK_NY_UNITED_STATES;

        User newUser = manager.createUser("Tom", 5, 3, 2, 1, 1);
        JobOffer offer1 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "JobOffer1", "JobOffer1", location2.getName(), 150000, 10000, 12000, 5, 15, location2.getCostOfLiving());
        double score = Ranker.computeJobOfferScore(newUser.getUserWeights(),offer1);

        assertEquals(score, 68346.15,.01);

    }

}
