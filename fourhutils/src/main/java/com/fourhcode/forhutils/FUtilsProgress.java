package com.fourhcode.forhutils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Created by developerhendy on 9/16/16.
 * © 2016.
 */

public class FUtilsProgress {

    private View progressLayout;
    private RelativeLayout parentLayout;
    private static FUtilsProgress instance;
    Context context;


    public static FUtilsProgress config(Context context, RelativeLayout wrapper) {
        instance = new FUtilsProgress(wrapper, context);
        return instance;
    }

    public static FUtilsProgress config(Fragment fragment, RelativeLayout wrapper) {
        instance = new FUtilsProgress(wrapper, fragment.getActivity());
        return instance;
    }

    public static FUtilsProgress config(Activity activity, RelativeLayout wrapper) {
        instance = new FUtilsProgress(wrapper, activity);
        return instance;
    }


    private static FUtilsProgress getDefault() {
        return instance;
    }


    public FUtilsProgress(RelativeLayout parentLayout, Context context) {
        this.parentLayout = parentLayout;
        this.context = context;
    }

    public static void showProgress() {
        getDefault().showProgressM();
    }


    public static void showProgressTransparent() {
        getDefault().showProgressTransparentM();
    }

    public static void dismiss() {
        getDefault().hideProgresss();

    }


    private void hideProgresss() {
        checkConfing();
        if (progressLayout != null) parentLayout.removeView(progressLayout);

    }


    private void showProgressM() {
        checkConfing();

        progressLayout =
                LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.futils_loading_layout, parentLayout, false);


        parentLayout.addView(progressLayout);


    }


    private void checkConfing() {
        if (parentLayout == null) {
            throw new FutilsException("FutilsProgress Didn't Configured by called config() method ");
        }
    }

    private void showProgressTransparentM() {
        checkConfing();
        Context context = Futils.getDefault().getContext();
        progressLayout =
                LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.futils_loading_transparent_layout, parentLayout, false);
        parentLayout.addView(progressLayout);


    }

    public static void disableFieldes(String textColorHash, EditText... editTexts) {
        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i].setTextColor(Color.parseColor(textColorHash));
            editTexts[i].setFocusable(false);
        }
    }


    public static void enableFields(String defaultColorHash, EditText... editTexts) {
        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i].setTextColor(Color.parseColor(defaultColorHash));
            editTexts[i].setFocusableInTouchMode(true);
            editTexts[i].setFocusable(true);
        }
    }


}
