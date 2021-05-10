package com.shopping.latdtest;

import android.app.Application;

import io.branch.referral.Branch;

public class CustomApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Branch.enableLogging();
        Branch.getAutoInstance(this);
    }
}
