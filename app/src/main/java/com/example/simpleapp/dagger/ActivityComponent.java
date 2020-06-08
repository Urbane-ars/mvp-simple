package com.example.simpleapp.dagger;

import com.example.simpleapp.mvp.UsersActivity;

import dagger.Component;

@Component(modules = {ActivityModule.class})
@ActivityScope
public interface ActivityComponent {
    void inject(UsersActivity activity);
}
