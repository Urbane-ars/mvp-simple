package com.example.simpleapp.dagger;


import com.example.simpleapp.mvp.UsersActivity;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(UsersActivity activity);
}
