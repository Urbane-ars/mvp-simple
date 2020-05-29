package com.example.simpleapp.mvp;


import com.example.simpleapp.common.User;

import java.util.List;

public interface UsersContactView {
    UserData getUserData();
    void showUsers(List<User> users);
    void showToast(int resId);
    void showProgress();
    void hideProgress();
}
