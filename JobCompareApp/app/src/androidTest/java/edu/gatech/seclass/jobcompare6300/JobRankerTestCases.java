package edu.gatech.seclass.jobcompare6300;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.jobs.JobComparer;
import edu.gatech.seclass.jobcompare6300.jobs.JobManager;
import edu.gatech.seclass.jobcompare6300.storage.database.UserDatabase;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class JobRankerTestCases {
    @Test
    public void JobRankerTest() {
        // Context of the app under test.
        Context context = ApplicationProvider.getApplicationContext();
        UserDatabase userDatabase = Room.inMemoryDatabaseBuilder(context, UserDatabase.class).build();
        JobManager manager = new JobManager(userDatabase);
        User newUser = manager.createUser("test", 1, 1, 1, 1, 1);
        JobOffer offer1 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "Software Engineer 3", "Example Company 3", "Boston", 500000, 10000, 10000, 40, 40, 1);
        JobOffer offer2 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "Software Engineer 2", "Example Company 2", "Boston", 50000, 1000, 1000, 30, 30, 1);
        JobOffer offer3 = manager.createJobOfferForUser(newUser, newUser.getUserId(), "Software Engineer 1", "Example Company 1", "Boston", 5000, 100, 100, 20, 20, 1);
        ArrayList<JobOffer> allOffers = new ArrayList<JobOffer>();
        allOffers.add(offer1);
        allOffers.add(offer2);
        allOffers.add(offer3);
        JobComparer comparer = new JobComparer(newUser.getUserWeights(), allOffers, new ArrayList<JobOffer>());
        comparer.selectJob(0);
        comparer.selectJob(1);
        comparer.selectJob(2);
        List<JobOffer> rankedOffers = comparer.rankSelectedJobOffers();
        List<JobOffer> expectedList = new ArrayList<JobOffer>();
        expectedList.add(offer1);
        expectedList.add(offer2);
        expectedList.add(offer3);
        assertEquals(rankedOffers, expectedList);
    }
}
