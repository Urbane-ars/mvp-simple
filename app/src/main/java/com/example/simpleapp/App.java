package com.example.simpleapp;

import android.app.Application;

import com.example.simpleapp.dagger.AppComponent;
import com.example.simpleapp.dagger.AppModule;
import com.example.simpleapp.dagger.DaggerAppComponent;


public class App extends Application {
    private  AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

   public AppComponent getAppComponent(){
        return appComponent;
    }


}


