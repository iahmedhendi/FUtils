package com.fourhcode.forhutils;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by developerhendy on 9/16/16.
 * © 2016.
 */

public class FUtilsProgress {


    private RelativeLayout parentLayout;
    private static FUtilsProgress futils;
    private Activity activity;
    View recyclerView;

    public static FUtilsProgress getDefault() {

        if (futils == null) {

            futils = new FUtilsProgress();

        }
        return futils;
    }


    public FUtilsProgress() {
        parentLayout = Futils.getDefault().getParentLayout();
        activity = Futils.getDefault().getActivity();
        recyclerView = Futils.getDefault().getRecyclerView();
    }

    public static void showProgress() {
        getDefault().showProgressM();
    }


    public static void showProgressT() {
        getDefault().showProgressTransparentM();
    }

    public static void dismiss() {
        getDefault().hideProgresss();

    }





    public void hideProgresss() {
        checkConfing();

        if (activity.findViewById(R.id.futils_loading_lay) != null) {
            activity.findViewById(R.id.futils_loading_lay).setVisibility(View.GONE);
        } else {
            Log.e("Futils", "no progress");
        }

        if (activity.findViewById(R.id.futils_transparent_loading_lay) != null) {
            activity.findViewById(R.id.futils_transparent_loading_lay).setVisibility(View.GONE);
        } else {
            Log.e("Futils", "no progress");
        }

        if (recyclerView != null)
            recyclerView.setVisibility(View.VISIBLE);
    }


    public void showProgressM() {
        checkConfing();

        if (activity.findViewById(R.id.futils_loading_lay) != null) {
            activity.findViewById(R.id.futils_loading_lay).setVisibility(View.VISIBLE);
        } else {
            RelativeLayout view = (RelativeLayout) LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.futils_loading_layout, null, false);
            ViewGroup.LayoutParams params = parentLayout.getLayoutParams();
            view.setLayoutParams(params);
            parentLayout.addView(view);
        }
        if (recyclerView != null) recyclerView.setVisibility(View.GONE);


    }


    private void checkConfing() {
        if (parentLayout == null) {
            throw new FutilsException("Futils Didn't Configured by called config() method or activity root view not Relative layout");
        }
    }

    public void showProgressTransparentM() {
        checkConfing();

        if (activity.findViewById(R.id.futils_transparent_loading_lay) != null) {
            activity.findViewById(R.id.futils_transparent_loading_lay).setVisibility(View.VISIBLE);
        } else {
            RelativeLayout view = (RelativeLayout) LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.futils_loading_transparent_layout, null, false);
            ViewGroup.LayoutParams params = parentLayout.getLayoutParams();
            view.setLayoutParams(params);
            parentLayout.addView(view);
        }

        if (recyclerView != null) recyclerView.setVisibility(View.GONE);


    }




}
