package edu.gatech.seclass.jobcompare6300;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.gatech.seclass.jobcompare6300.storage.dao.UserDao;
import edu.gatech.seclass.jobcompare6300.storage.database.UserDatabase;
import edu.gatech.seclass.jobcompare6300.storage.entities.User;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.stream.Collectors;

public class SelectUser extends Fragment {
    private SelectUserListener listener;
    private UserDatabase userDatabase;
    private UserDao userDao;
    private List<User> allUsers;
    private FloatingActionButton addUserButton;
    private GridView gridView;

    public interface SelectUserListener {
        void onSelectedUser(User selectedUser);
    }

    static SelectUser newInstance() {
        return new SelectUser();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_user, container, false);
        this.userDatabase = UserDatabase.getInstance(view.getContext());
        this.userDao = this.userDatabase.userDao();
        allUsers = this.userDao.getUsers();
        addUserButton = view.findViewById(R.id.addUserButton);
        gridView = view.findViewById(R.id.UserGridID);
        addUserButton.setOnClickListener(myView -> {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_container,
                            AddUser.newInstance(),
                            "AddJob")
                    .addToBackStack("AddJob")
                    .commit();
        });
        displayUsers();
        return view;
    }

    private void displayUsers() {
        List<String> userNames = allUsers.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        ArrayAdapter<String> userArrAdapter = new ArrayAdapter<>(
            getContext(),
            android.R.layout.simple_list_item_1,
            userNames);
        gridView.setAdapter(userArrAdapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            User selectedUserWithOffer = allUsers.get(position);
            listener.onSelectedUser(selectedUserWithOffer);
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SelectUserListener) {
            listener = (SelectUserListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement SelectUserListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
