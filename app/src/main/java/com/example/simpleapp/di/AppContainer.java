package com.example.simpleapp.di;


import android.content.Context;

import com.example.simpleapp.database.DbHelper;
import com.example.simpleapp.mvp.UsersModel;


public class AppContainer {

    public UsersModel getUsersModel(Context context) {
        return new UsersModel(new DbHelper(context));
    }
}
