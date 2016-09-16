package com.fourhcode.forhutils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by developerhendy on 9/16/16.
 * © 2016.
 */

public class FUtilsInternet {
    private Context context;
    private static FUtilsInternet instance;
    private NetworkInfo activeNetwork;
    private ConnectivityManager cm;

    private RelativeLayout parentLayout;
    private static FUtilsProgress futils;
    private Activity activity;
    View recyclerView;


    private FUtilsInternet() {
        parentLayout = Futils.getDefault().getParentLayout();
        activity = Futils.getDefault().getActivity();
        recyclerView = Futils.getDefault().getRecyclerView();
        context = Futils.getDefault().getContext();
        cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        checkConfing();

    }


    private static FUtilsInternet getInstance() {
        if (instance == null) {
            instance = new FUtilsInternet();

        }

        return instance;
    }

    public static boolean isConnected() {
        return getInstance().isConnectedM();
    }


    public static boolean isWifi() {
        return getInstance().isWifiM();
    }

    private boolean isConnectedM() {

        activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

    }

    private boolean isWifiM() {
        if (activeNetwork == null) activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;

    }

    public static void showNoInternetPage(View.OnClickListener tryAgainListener) {
        getInstance().showNoInternetPageM(tryAgainListener);
    }


    public static void showNoInternetPage(NoInternetPage noInternetPage, View.OnClickListener tryAgainListener) {
        getInstance().showNoInternetPageM(noInternetPage, tryAgainListener);

    }

    public void showNoInternetPageM(final View.OnClickListener tryagainListener) {
        checkConfing();

        if (activity.findViewById(R.id.futils_no_internet_layout) != null) {
            activity.findViewById(R.id.futils_no_internet_layout).setVisibility(View.VISIBLE);
        } else {
            RelativeLayout view = (RelativeLayout) LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.futils_no_internet, null, false);
            ViewGroup.LayoutParams params = parentLayout.getLayoutParams();
            view.setLayoutParams(params);
            parentLayout.setFocusable(false);
            TextView tryAgain = (TextView) view.findViewById(R.id.try_again_text);
            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hideNoInternet();
                    tryagainListener.onClick(v);
                }
            });
            parentLayout.addView(view);
        }


    }

    public void showNoInternetPageM(NoInternetPage noInternetPage, final View.OnClickListener tryagainListener) {
        checkConfing();

        if (activity.findViewById(R.id.futils_no_internet_layout) != null) {
            activity.findViewById(R.id.futils_no_internet_layout).setVisibility(View.VISIBLE);
        } else {
            RelativeLayout view = (RelativeLayout) LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.futils_no_internet, null, false);
            ViewGroup.LayoutParams params = parentLayout.getLayoutParams();
            view.setLayoutParams(params);
            parentLayout.setFocusable(false);
            TextView tryAgain = (TextView) view.findViewById(R.id.try_again_text);
            TextView noInternetText = (TextView) view.findViewById(R.id.no_internet_text);
            tryAgain.setText(noInternetPage.getTryAgainText());
            noInternetText.setText(noInternetPage.getNoInternetText());

            tryAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hideNoInternet();
                    tryagainListener.onClick(v);
                }
            });


            parentLayout.addView(view);
        }


    }


    private void checkConfing() {
        if (parentLayout == null) {
            throw new FutilsException("Futils Didn't Configured by called config() method or activity root view not Relative layout");
        }
    }

    private void hideNoInternet() {
        checkConfing();
        if (activity.findViewById(R.id.futils_no_internet_layout) != null) {
            activity.findViewById(R.id.futils_no_internet_layout).setVisibility(View.GONE);
            parentLayout.setFocusable(true);
        }
    }

}
