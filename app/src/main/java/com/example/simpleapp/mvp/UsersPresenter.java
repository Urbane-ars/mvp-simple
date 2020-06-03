package com.example.simpleapp.mvp;

import android.content.ContentValues;
import android.text.TextUtils;

import com.example.simpleapp.R;
import com.example.simpleapp.common.User;
import com.example.simpleapp.common.UserTable;

import java.util.List;

import javax.inject.Inject;

public class UsersPresenter {

    private UsersContactView view;
    private final UsersModel model;

    @Inject
    public UsersPresenter(UsersModel model) {
        this.model = model;
    }

    public void attachView(UsersContactView usersActivity) {
        view = usersActivity;
    }

    public void detachView() {
        view = null;
    }


    public void viewIsReady() {
        loadUsers();
    }

    public void loadUsers() {
        model.loadUsers(new UsersModel.LoadUserCallback() {
            @Override
            public void onLoad(List<User> users) {
                view.showUsers(users);
            }
        });
    }

    public void add() {
        User user = view.getUser();
        if (TextUtils.isEmpty(user.getName()) || TextUtils.isEmpty(user.getEmail())) {
            view.showToast(R.string.empty_values);
            return;
        }

        ContentValues cv = new ContentValues(2);
        cv.put(UserTable.COLUMN.NAME, user.getName());
        cv.put(UserTable.COLUMN.EMAIL, user.getEmail());
        view.showProgress();
        model.addUser(cv, new UsersModel.CompleteCallback() {
            @Override
            public void onComplete() {
                view.hideProgress();
                loadUsers();
            }
        });
    }

    public void clear() {
        view.showProgress();
        model.clearUsers(new UsersModel.CompleteCallback() {
            @Override
            public void onComplete() {
                view.hideProgress();
                loadUsers();
            }
        });
    }

}
