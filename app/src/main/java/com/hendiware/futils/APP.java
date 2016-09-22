package com.hendiware.futils;

import android.app.Application;

import com.fourhcode.forhutils.FUtilsSession;

/**
 * Created by developerhendy on 9/22/16.
 * © 2016.
 */

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FUtilsSession.getInstance().config(getApplicationContext());
    }
}
