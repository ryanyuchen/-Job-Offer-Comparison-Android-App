package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.gatech.seclass.jobcompare6300.storage.dao.UserDao;
import edu.gatech.seclass.jobcompare6300.storage.database.UserDatabase;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;
import edu.gatech.seclass.jobcompare6300.storage.entities.UserWeights;

public class AddUser extends Fragment {

    private UserDatabase userDatabase;
    private UserDao userDao;
    private Button addUserButton;

    static AddUser newInstance() {
        return new AddUser();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_user, container, false);
        userDatabase = UserDatabase.getInstance(view.getContext());
        userDao = this.userDatabase.userDao();
        addUserButton = view.findViewById(R.id.addButtonID);
        addUserButton.setOnClickListener(myView -> addUser(view));

        SeekBar salaryWeightSlider = view.findViewById(R.id.SalaryWeightSliderID);
        final TextView salaryWeightView = view.findViewById(R.id.SalaryWeightValueID);
        setSeekBarDisplay(salaryWeightSlider, salaryWeightView);

        SeekBar signingBonusWeightSlider = view.findViewById(R.id.SigningBonusWeightSliderID);
        final TextView signingBonusView = view.findViewById(R.id.SigningBonusWeightValueID);
        setSeekBarDisplay(signingBonusWeightSlider, signingBonusView);

        SeekBar bonusWeightSlider = view.findViewById(R.id.BonusWeightSliderID);
        final TextView bonusView = view.findViewById(R.id.BonusWeightValueID);
        setSeekBarDisplay(bonusWeightSlider, bonusView);

        SeekBar retirementSlider = view.findViewById(R.id.RetirementWeightSliderID);
        final TextView retirementView = view.findViewById(R.id.RetirementWeightValueID);
        setSeekBarDisplay(retirementSlider, retirementView);

        SeekBar ptoSlider = view.findViewById(R.id.PTOWeightSliderID);
        final TextView ptoView = view.findViewById(R.id.PTOWeightValueID);
        setSeekBarDisplay(ptoSlider, ptoView);
        return view;
    }

    private void setSeekBarDisplay(SeekBar seekbar, final TextView view) {
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // updated continuously as the user slides the thumb
                view.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // called when the user first touches the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // called after the user finishes moving the SeekBar
            }
        });
    }


    private void addUser(View view) {
        // views that contains the slider values
        EditText name = view.findViewById(R.id.NameInputID);
        if (name.getText().toString().isEmpty()) {
            name.setError("Please enter a username");
            return;
        }
        SeekBar salaryWeight = view.findViewById(R.id.SalaryWeightSliderID);
        SeekBar signingBonusWeight = view.findViewById(R.id.SigningBonusWeightSliderID);
        SeekBar bonusWeight = view.findViewById(R.id.BonusWeightSliderID);
        SeekBar retirementWeight = view.findViewById(R.id.RetirementWeightSliderID);
        SeekBar ptoWeight = view.findViewById(R.id.PTOWeightSliderID);
        UserWeights weights = new UserWeights.Builder()
                .setSalaryWeight(salaryWeight.getProgress())
                .setSigningBonusWeight(signingBonusWeight.getProgress())
                .setYearlyBonusWeight(bonusWeight.getProgress())
                .setRetirementBenefitsWeight(retirementWeight.getProgress())
                .setPtoWeight(ptoWeight.getProgress())
                .build();

        User newUser = new User.Builder()
                .setName(name.getText().toString())
                .setUserWeights(weights).build();
        userDao.insertOrUpdate(newUser);
        Toast.makeText(view.getContext(), "User " + name.getText().toString() + " created",
                Toast.LENGTH_SHORT).show();
        // Close the keyboard.
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
            .hideSoftInputFromWindow(view.getWindowToken(),0);
        // Jump to select user screen, pop self from backstack.
        getFragmentManager().popBackStack();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_container,
                        SelectUser.newInstance(),
                        "SelectUser")
                .commit();
    }


}
