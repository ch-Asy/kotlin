package com.cn.kotlin.life.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ann.http.iml.SubscriberOnNextListener;
import com.cn.kotlin.HttpCl;
import com.cn.kotlin.R;
import com.cn.kotlin.life.dagger.Injectable;
import com.cn.kotlin.BannerData;
import com.cn.kotlin.life.model.User;
import com.emof.base.BaseActivity;
import com.ann.http.ProgressSubscriber;
import com.emof.fitlibrary.permission.NPermission;
import com.emof.fitlibrary.permission.PermissionCallback;
import com.emof.iml.LayoutResId;


import org.jetbrains.annotations.NotNull;

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

        HttpCl.getInstance(0).banner(new ProgressSubscriber<BannerData>(this,
                new SubscriberOnNextListener<BannerData>() {
                    @Override
                    public void onNext(BannerData bannerData) {
                        Log.d("-----", bannerData.toString());
                    }

                    @Override
                    public void onError() {

                    }
                }, true, true, ""));
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
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@NonNull Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                int rgb = vibrantSwatch.getRgb();
                toolbar.setBackgroundColor(rgb);
            }
        });

        findViewById(R.id.permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NPermission.create(UserProfileActivity.this)
                        .checkMutiPermission( new PermissionCallback() {
                            @Override
                            public void onClose() {

                            }

                            @Override
                            public void onFinish() {

                            }

                            @Override
                            public void onDeny(@NotNull String permission, int position) {

                            }

                            @Override
                            public void onGuarantee(@NotNull String permission, int position) {

                            }
                        });
            }
        });
    }

    @Override
    protected void beginServer() {

    }
}
