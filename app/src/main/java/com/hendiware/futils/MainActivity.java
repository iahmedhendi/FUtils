package com.hendiware.futils;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.fourhcode.forhutils.FUtilsInternet;
import com.fourhcode.forhutils.Futils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Futils.getDefault().config(this, (RelativeLayout) findViewById(R.id.activity_main_layout));

        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Toast.makeText(getBaseContext(), FUtilsInternet.isWifi() ? "متصل بالواى فاى " : "غير متصل بالواى فاى", Toast.LENGTH_LONG).show();
            }
        }.start();

        new CountDownTimer(2000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                FUtilsInternet.showNoInternetPage(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        }.start();
    }
}
