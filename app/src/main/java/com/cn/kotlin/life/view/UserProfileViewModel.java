package com.cn.kotlin.life.view;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.VisibleForTesting;

import com.cn.kotlin.life.model.User;
import com.cn.kotlin.life.repo.UserProfileRepository;

import javax.inject.Inject;


/**
 * Created by anliyuan on 2017/11/7.
 */

public class UserProfileViewModel extends ViewModel {
    private LiveData<User> user;
    MutableLiveData<Integer> userid=new MutableLiveData<>();
    private UserProfileRepository repo;

    public UserProfileViewModel() {
        this.repo = new UserProfileRepository();
        user= Transformations.switchMap(this.userid, new Function<Integer, LiveData<User>>() {
            @Override
            public LiveData<User> apply(Integer input) {
                return repo.getUser(input);
            }
        });
    }

    public void init(int userid) {
        if (userid == 0) {
            return;
        }
        this.userid.setValue(userid);
    }
    public LiveData<User> getUser(){
        return this.user;
    }
}
