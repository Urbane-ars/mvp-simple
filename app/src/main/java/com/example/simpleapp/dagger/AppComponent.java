package com.example.simpleapp.dagger;


import com.example.simpleapp.database.DbHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    DbHelper dbHelper();
}
