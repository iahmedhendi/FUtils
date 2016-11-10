package com.fourhcode.forhutils;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by developerhendy on 9/16/16.
 * © 2016.
 */

public class FUtilsInternet {
    private NetworkInfo activeNetwork;
    private ConnectivityManager cm;

    private View noInternetLayout;


    private RelativeLayout parentLayout;
    private static FUtilsInternet instance;
    Context context;

    private final String TAG = FUtilsInternet.this.getClass().getName();

    public static FUtilsInternet config(Context context, RelativeLayout wrapper) {
        instance = new FUtilsInternet(wrapper, context);
        return instance;
    }

    public static FUtilsInternet config(Fragment fragment, RelativeLayout wrapper) {
        instance = new FUtilsInternet(wrapper, fragment.getActivity());
        return instance;
    }

    public static FUtilsInternet config(Activity activity, RelativeLayout wrapper) {
        instance = new FUtilsInternet(wrapper, activity);
        return instance;
    }


    private FUtilsInternet(RelativeLayout parentLayout, Context context) {
        this.parentLayout = parentLayout;
        this.context = context;
        cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

    }


    private static FUtilsInternet getInstance() {
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
        noInternetLayout =
                LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.futils_no_internet, parentLayout, false);


        TextView tryAgain = (TextView) noInternetLayout.findViewById(R.id.try_again_text);


        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNoInternet();
                tryagainListener.onClick(v);
            }
        });

        parentLayout.addView(noInternetLayout);

    }

    public void showNoInternetPageM(final NoInternetPage noInternetPage, final View.OnClickListener tryagainListener) {
        checkConfing();

        noInternetLayout =
                LayoutInflater.from(parentLayout.getContext()).inflate(R.layout.futils_no_internet, parentLayout, false);


        TextView tryAgain = (TextView) noInternetLayout.findViewById(R.id.try_again_text);
        TextView noInternetText = (TextView) noInternetLayout.findViewById(R.id.no_internet_text);
        ImageView noInternetIcon = (ImageView) noInternetLayout.findViewById(R.id.no_internet_img);
        if (noInternetPage.getTryAgainText() != null) {
            tryAgain.setText(noInternetPage.getTryAgainText());
        }

        if (noInternetPage.getIcon() != 0)
            noInternetIcon.setImageResource(noInternetPage.getIcon());

        if (noInternetPage.getNoInternetText() != null) {
            noInternetText.setText(noInternetPage.getNoInternetText());

        }

        if (noInternetPage.getBackgroundColorHex() != null)
            noInternetLayout.setBackgroundColor(Color.parseColor(noInternetPage.getBackgroundColorHex()));

        if (noInternetPage.getTryAgainTextColor() != null)
            tryAgain.setTextColor(Color.parseColor(noInternetPage.getTryAgainTextColor()));

        if (noInternetPage.getTextColor() != null)
            try {
                noInternetText.setTextColor(Color.parseColor(noInternetPage.getTextColor()));
            } catch (NumberFormatException e) {
                Log.e(TAG,"Can't Color the text please Write a valide color hex code for example #2451a9 ");
            }

        if (noInternetPage.getFontPath() != null) {
            Typeface type = Typeface.createFromAsset(context.getAssets(), noInternetPage.getFontPath());
            noInternetText.setTypeface(type);
            tryAgain.setTypeface(type);
        }

        if (noInternetPage.isAnimation()) {
            noInternetLayout.setTranslationX(-1200f);
            ViewPropertyAnimator animation = noInternetLayout.animate().translationXBy(1200).setDuration(500);
            animation.setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            animation.start();
        }


        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNoInternet(noInternetPage);
                tryagainListener.onClick(v);
            }
        });

        parentLayout.addView(noInternetLayout);


    }


    private void checkConfing() {
        if (parentLayout == null) {
            throw new FutilsException("Futils Didn't Configured by called config() method or activity root view not Relative layout");
        }
    }

    private void hideNoInternet() {
        checkConfing();
        if (noInternetLayout != null) {
            parentLayout.removeView(noInternetLayout);
        }

    }

    private void hideNoInternet(NoInternetPage noInternetPage) {
        checkConfing();

        if (noInternetLayout != null) {
            if (noInternetPage.isAnimation()) {
                ViewPropertyAnimator animation = noInternetLayout.animate().translationXBy(-1200).setDuration(500);
                animation.setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        parentLayout.removeView(noInternetLayout);

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

                animation.start();
            } else {
                parentLayout.removeView(noInternetLayout);
            }

        }

    }


}
