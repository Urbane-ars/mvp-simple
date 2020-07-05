package com.example.simpleapp.dagger;

import android.content.Context;

import com.example.simpleapp.database.DbHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Module
@InstallIn(ApplicationComponent.class)
public class AppModule {

    @Provides
    @Singleton
    static DbHelper providesDbHelper(@ApplicationContext Context context){
        return new DbHelper(context);
    }
}
