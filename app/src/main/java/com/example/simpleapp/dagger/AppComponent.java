package com.example.simpleapp.dagger;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {
}
