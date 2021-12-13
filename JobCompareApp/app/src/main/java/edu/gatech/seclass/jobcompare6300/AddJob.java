package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import androidx.fragment.app.Fragment;

import java.util.function.Function;

import edu.gatech.seclass.jobcompare6300.filters.IntegerFilter;
import edu.gatech.seclass.jobcompare6300.locations.LocationUtil;
import edu.gatech.seclass.jobcompare6300.storage.dao.UserDao;
import edu.gatech.seclass.jobcompare6300.storage.database.UserDatabase;
import edu.gatech.seclass.jobcompare6300.storage.entities.JobOffer;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddJob#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddJob extends Fragment {

    private User currentUser;
    private UserDatabase userDatabase;
    private UserDao userDao;
    private Button addJobButton;
    private SearchableSpinner spinner;

    private AddJob(User selectedUser) {
        currentUser = selectedUser;
    }


    static AddJob newInstance(User user) {
        return new AddJob(user);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_job, container, false);
        userDatabase = UserDatabase.getInstance(view.getContext());
        userDao = this.userDatabase.userDao();
        addJobButton = view.findViewById(R.id.addJobButton);
        addJobButton.setOnClickListener(myView -> addJob(view));
        spinner = view.findViewById(R.id.LocationInput);
        setUpSpinner();

        // Get the integer filters.
        IntegerFilter retirementPctFilter = new IntegerFilter(100, this::getContext);
        EditText retirementPct = view.findViewById(R.id.RetirementInput);
        retirementPct.setFilters(new InputFilter[]{retirementPctFilter});

        IntegerFilter ptoFilter = new IntegerFilter(260, this::getContext);
        EditText pto = view.findViewById(R.id.LeaveTimeInput);
        pto.setFilters(new InputFilter[]{ptoFilter});

        return view;
    }

    private void setUpSpinner() {
        spinner.setTitle("Select Location");
        ArrayAdapter<LocationUtil.Location> locationArrayAdapter =
            new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                LocationUtil.ALL_LOCATIONS);
        spinner.setAdapter(locationArrayAdapter);
    }

    private void addJob(View view) {
        EditText title = view.findViewById(R.id.TitleInput);
        EditText company = view.findViewById(R.id.CompanyInput);
        LocationUtil.Location location = (LocationUtil.Location) spinner.getSelectedItem();

        if (invalidInput(title, "Job Title")
                || invalidInput(company, "Company")) {
            return;
        }

        EditText salary = view.findViewById(R.id.SalaryInput);
        EditText signingBonus = view.findViewById(R.id.SigningBonusInput);
        EditText yearlyBonus = view.findViewById(R.id.YearlyBonusInput);
        EditText retirementMatch = view.findViewById(R.id.RetirementInput);
        EditText leaveTime = view.findViewById(R.id.LeaveTimeInput);

        JobOffer newJobOffer = new JobOffer.Builder()
                .setUserId(currentUser.getUserId())
                .setTitle(title.getText().toString())
                .setCompany(company.getText().toString())
                .setLocation(location.getName())
                .setSalary(textViewValue(salary, Double::parseDouble, 0.0))
                .setSigningBonus(textViewValue(signingBonus, Double::parseDouble, 0.0))
                .setYearlyBonus(textViewValue(yearlyBonus, Double::parseDouble, 0.0))
                .setRetirementPctMatch(textViewValue(retirementMatch, Double::parseDouble, 0.0))
                .setPtoDays(textViewValue(leaveTime, Integer::parseInt, 0))
                .setOverallCostOfLiving(location.getCostOfLiving())
                .build();

        userDao.insertOrUpdate(newJobOffer);
        Toast.makeText(view.getContext(), "Job saved",
                Toast.LENGTH_SHORT).show();
        // Close the keyboard.
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
            .hideSoftInputFromWindow(view.getWindowToken(),0);
        getFragmentManager().popBackStack();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_container, new JobOverview(currentUser))
                .commit();
    }

    private static <T> T textViewValue(
            EditText textView, Function<String, T> parseFn, T defaultValue) {
        String text = textView.getText().toString();
        if (text.isEmpty()) {
            return defaultValue;
        }
        return parseFn.apply(text);
    }

    private static boolean invalidInput(EditText input, String inputName) {
        if (input.getText().toString().isEmpty()) {
            input.setError("Please enter a " + inputName);
            return true;
        }
        return false;
    }
}
