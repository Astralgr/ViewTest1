package io.designparadise.hello.viewtest1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.net.InetAddress;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        final AdView mAdView = (AdView) findViewById(R.id.adView);

        ConnectivityManager cManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();

        if (nInfo !=null && nInfo.isConnected()){
            Toast.makeText(this, "Wifi is ACTIVE", Toast.LENGTH_LONG).show();

            mAdView.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    mAdView.setVisibility(View.VISIBLE);
                }
            });

        } else {
            Toast.makeText(this, "Wifi is INACTIVE", Toast.LENGTH_LONG).show();

        }




     //   AdRequest.Builder.addTestDevice("613C3A6C7D38A0BFBE8DF9A3D499B03D")

/*        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("613C3A6C7D38A0BFBE8DF9A3D499B03D")  // An example device ID
                .build();
        mAdView.loadAd(request);

**/


// request test banner ads
      AdRequest adRequest = new AdRequest.Builder()
              .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
              .addTestDevice("613C3A6C7D38A0BFBE8DF9A3D499B03D")
              .tagForChildDirectedTreatment(true)
              .build();

       mAdView.loadAd(adRequest);


    }
}
