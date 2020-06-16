package com.example.simpleapp.dagger;

import android.content.Context;

import com.example.simpleapp.database.DbHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context appContext){
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    Context providesContext(){
        return appContext;
    }

    @Provides
    @Singleton
    DbHelper providesDbHelper(Context context){
        return new DbHelper(context);
    }
}
