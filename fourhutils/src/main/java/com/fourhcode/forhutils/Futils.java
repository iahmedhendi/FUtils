package com.fourhcode.forhutils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by hendi on 8/28/16.
 */
public class Futils {

    private static Futils futils;
    private RelativeLayout parentLayout;
    private Activity activity;
    View recyclerView;
    private Context context;

    public Context getContext() {
        return context;
    }

    public static Futils getDefault() {

        if (futils == null) {

            futils = new Futils();
        }
        return futils;
    }


    public RelativeLayout getParentLayout() {
        return parentLayout;
    }

    public Activity getActivity() {
        return activity;
    }

    public View getRecyclerView() {
        return recyclerView;
    }

    public Futils config(Activity activity) {
        this.parentLayout = (RelativeLayout) ((ViewGroup) activity
                .findViewById(android.R.id.content)).getChildAt(0);
        this.activity = activity;
        context = activity;
        return this;

    }

    public Futils hide(View view) {
        recyclerView = view;
        return this;
    }

    public Futils config(Activity activity, RelativeLayout wrapper) {
        this.parentLayout = wrapper;
        this.activity = activity;
        context = activity;

        return this;

    }

    public Futils config(Fragment fragment, View view) {

        this.parentLayout = (RelativeLayout) view;
        this.activity = fragment.getActivity();
        context = activity;

        return this;

    }


    public Futils config(Fragment fragment, RelativeLayout wrapper) {

        this.parentLayout = wrapper;
        this.activity = fragment.getActivity();
        context = activity;

        return this;

    }


}
