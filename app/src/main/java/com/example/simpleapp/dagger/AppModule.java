package com.example.simpleapp.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context appContext){
        this.appContext = appContext;
    }

    @Provides
    @AppScope
    Context providesContext(){
        return appContext;
    }
}
