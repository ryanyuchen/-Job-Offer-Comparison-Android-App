package edu.gatech.seclass.jobcompare6300;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.jobs.JobComparer;
import edu.gatech.seclass.jobcompare6300.storage.dao.UserDao;
import edu.gatech.seclass.jobcompare6300.storage.database.UserDatabase;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;

public class JobOverview extends Fragment {

    private UserDatabase userDatabase;
    private UserDao userDao;
    private TableLayout table;
    private User currentUser;
    private JobComparer jobComparer;


    JobOverview(User selectedUser) {
        super();
        currentUser = selectedUser;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.job_overview, container, false);
        this.userDatabase = UserDatabase.getInstance(view.getContext());
        this.userDao = this.userDatabase.userDao();
        table = view.findViewById(R.id.JobsTable);
        FloatingActionButton compareButton = view.findViewById(R.id.CompareButton);
        FloatingActionButton addJobButton = view.findViewById(R.id.AddJobButton);
        FloatingActionButton deleteJobButton = view.findViewById(R.id.DeleteJobButton);
        jobComparer = new JobComparer(currentUser.getUserWeights(),
                (ArrayList<JobOffer>) this.userDao.getOffersForUser(currentUser.getUserId()),
                new ArrayList<>());
        compareButton.setOnClickListener(myView -> {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_container,
                            JobOffersCompare.newInstance(currentUser,
                                    jobComparer.rankSelectedJobOffers(),
                                    1),
                            "RankJobs")
                    .addToBackStack("RankJobs")
                    .commit();
        });
        addJobButton.setOnClickListener(myView -> {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_container,
                            AddJob.newInstance(currentUser),
                            "addJob")
                    .addToBackStack("addJob")
                    .commit();
        });

        deleteJobButton.setOnClickListener(myView ->{
            List<JobOffer> selected = jobComparer.getSelectedOffers();
            for(JobOffer offer: selected){
                userDao.deleteOffer(offer);
            }
            getFragmentManager().beginTransaction()
                    .detach(JobOverview.this)
                    .attach(JobOverview.this)
                    .commit();
        });

        displayJobs(view);
        return view;
    }


    private void displayJobs(View view) {
        long userID = currentUser.getUserId();
        List<JobOffer> jobOffers = this.userDao.getOffersForUser(userID);
        for (int i = 0; i < jobOffers.size(); i++) {
            // create a new table row
            TableRow newRow = new TableRow(view.getContext());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            newRow.setLayoutParams(lp);
            JobOffer currentJob = jobOffers.get(i);
            // write the job title
            addTextView(currentJob.getTitle(), newRow, view);
            // write the location
            addTextView(currentJob.getLocation(), newRow, view);
            // write the company name
            addTextView(currentJob.getCompany(), newRow, view);
            // add radio button for selected
            CheckBox selected = new CheckBox(view.getContext());
            selected.setChecked(false);
            selected.setOnCheckedChangeListener((compoundButton, isUnchecked) -> {
                if (!isUnchecked){
                    jobComparer.unselectJob(currentJob);
                }
                else{
                    jobComparer.selectJob(currentJob);
                }
            });
            newRow.addView(selected);
            if (i % 2 == 0) {
                newRow.setBackgroundColor(Color.LTGRAY);
            }
            table.addView(newRow);
        }

    }

    // created each textview in the row and sets the layout params
    private void addTextView(String content, TableRow newRow, View view) {
        TextView textView = new TextView(view.getContext());
        textView.setText(content);
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT,
                1);
        params.setMargins(10, 0, 0, 0);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        newRow.addView(textView);
    }


}
