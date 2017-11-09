package com.cn.kotlin.life.repo;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.cn.kotlin.App;
import com.cn.kotlin.life.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;

/**
 * Created by anliyuan on 2017/11/7.
 */

@Singleton
public class UserProfileRepository {
    @Inject
    public UserProfileRepository(){

    }

    public LiveData<User> getUser(int userid){
        MutableLiveData<User> data = new MutableLiveData<>();
        User user;
        if (userid == 1) {
            user = new User("1", "asy", "23");
        } else {
            user = new User("2", "ann", "21");
        }
        data.setValue(user);
        return data;
    }
}
