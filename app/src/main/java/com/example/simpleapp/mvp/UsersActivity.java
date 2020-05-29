package com.example.simpleapp.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleapp.R;
import com.example.simpleapp.common.User;
import com.example.simpleapp.common.UserAdapter;
import com.example.simpleapp.di.App;
import com.example.simpleapp.di.AppContainer;

import java.util.List;


public class UsersActivity extends AppCompatActivity implements UsersContactView{

    private UserAdapter userAdapter;

    private EditText editTextName;
    private EditText editTextEmail;
    private ProgressDialog progressDialog;

    private UsersPresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        // with manual dependency injection
        AppContainer appContainer = ((App) getApplication()).appContainer;
        presenter = new UsersPresenter(appContainer.getUsersModel(this));

        //      Without dependency injection
        // dbHelper = new DbHelper(this);
        // usersModel = new UsersModel(dbHelper);
        // presenter = new UsersPresenter(usersModel);

        init();
    }

    private void init() {

        editTextName =  findViewById(R.id.name);
        editTextEmail =  findViewById(R.id.email);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.add();
            }
        });

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        userAdapter = new UserAdapter();

        RecyclerView userList = findViewById(R.id.list);
        userList.setLayoutManager(layoutManager);
        userList.setAdapter(userAdapter);


        presenter.attachView(this);
        presenter.viewIsReady();
    }

    public UserData getUserData() {
        UserData userData = new UserData();
        userData.setName(editTextName.getText().toString());
        userData.setEmail(editTextEmail.getText().toString());
        return userData;
    }

    @Override
    public void showUsers(List<User> users) {
        userAdapter.setData(users);
    }

    public void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    public void showProgress() {
        progressDialog = ProgressDialog.show(this, "", getString(R.string.please_wait));
    }

    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
