package com.cn.kotlin.life.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.cn.kotlin.R;
import com.cn.kotlin.life.dagger.Injectable;
import com.cn.kotlin.life.model.User;
import com.emof.base.BaseActivity;
import com.emof.iml.LayoutResId;

import javax.inject.Inject;


/**
 * Created by anliyuan on 2017/11/7.
 */

@LayoutResId(resId = R.layout.activity_user_profile)
public class UserProfileActivity extends BaseActivity implements Injectable {


    TextView user_info;

    UserProfileViewModel userProfileViewModel;

    @Inject
    ViewModelProvider.Factory factory;


    @Override
    protected void initData() {

    }

    public void changeUser(View view) {
        userProfileViewModel.init(2);
    }


    @Override
    protected void setToolbar(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        user_info = (TextView) findViewById(R.id.user_info);
        userProfileViewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        userProfileViewModel.init(1);
        userProfileViewModel.getUser().observeForever(new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                user_info.setText(user.toString());
            }
        });
    }

    @Override
    protected void beginServer() {

    }
}