package com.cn.kotlin.life.dagger;


import com.cn.kotlin.App;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        ViewModelModule.class
})
public interface AppComponent {
    void inject(App app);
}