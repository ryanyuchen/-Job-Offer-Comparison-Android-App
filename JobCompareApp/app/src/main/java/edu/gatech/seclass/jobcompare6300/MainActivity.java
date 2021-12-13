package edu.gatech.seclass.jobcompare6300;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        SelectUser.SelectUserListener,
        JobOffersCompare.OnListFragmentInteractionListener{

    private DrawerLayout drawerLayout;
    private User currentUser;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        // handles the navbar icon toggling
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_container, new SelectUser()).commit();
            navigationView.setCheckedItem(R.id.nav_user);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_jobs:
                if(currentUser == null){
                    Toast.makeText(getApplicationContext(),
                            "No User Currently Selected.",
                            Toast.LENGTH_SHORT).show();
                    return false;
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_container, new JobOverview(currentUser))
                        .addToBackStack("JobOverview")
                        .commit();
                break;
            case R.id.nav_user:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_container, new SelectUser())
                        .addToBackStack("SelectUser")
                        .commit();
                break;
        }
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onSelectedUser(User selectedUser) {
        View header = navigationView.getHeaderView(0);
        TextView username = header.findViewById(R.id.currentUser);
        username.setText(selectedUser.getName());
        currentUser = selectedUser;
    }

    @Override
    public void onListFragmentInteraction(JobOffer item) {
        // todo to handle action when an item on the job compare list is clicked
    }
}
