package com.example.simpleapp.dagger;



import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
  ActivityComponent activityComponent (ActivityModule activityModule);
}
