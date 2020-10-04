package com.montdeska.olddaggerapp.base;

import android.app.Activity;

import com.montdeska.olddaggerapp.home.MainActivity;
import com.montdeska.olddaggerapp.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        MainActivityComponent.class,
})
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> providerMainActivityInjector(MainActivityComponent.Builder builder);

}
