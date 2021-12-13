package edu.gatech.seclass.jobcompare6300.storage.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.gatech.seclass.jobcompare6300.storage.dao.UserDao;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;

@Database(entities = {JobOffer.class, User.class}, exportSchema = false, version = 1)
public abstract class UserDatabase extends RoomDatabase {

  private static final String DB_NAME = "user_db";

  private static UserDatabase instance;

  public abstract UserDao userDao();

  public static synchronized UserDatabase getInstance(Context context) {
    if (instance != null) {
      return instance;
    }
    instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DB_NAME)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build();
    return instance;
  }
}
