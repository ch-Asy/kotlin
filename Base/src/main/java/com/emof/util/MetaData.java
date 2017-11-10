package com.emof.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by anliyuan on 2017/11/10.
 */

public class MetaData {
    public static String getMetaData(Context context,String meta) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = packageManager.getApplicationInfo(context
                    .getPackageName(), PackageManager.GET_META_DATA);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return (String) applicationInfo.metaData.get(meta);
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(
                    "you must set " + meta + " and " + "  in your manifest file.", e);
        }
        return null;

    }
}
