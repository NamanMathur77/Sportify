package sport.mnapps.com.sample1;

/**
 * Created by user on 1/11/2018.
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

public class nz8 extends AppCompatActivity {
    public ImageView imageView;
    private AdView mAdView;
    String url = "https://firebasestorage.googleapis.com/v0/b/sample1-ae95d.appspot.com/o/nz8.png?alt=media&token=9fa14eeb-a08c-4a32-afaa-feb8993d369e";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagedownload);
        imageView=(ImageView)findViewById(R.id.imageView);
        loadImageFromUrl(url);
        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        imageView=(ImageView)findViewById(R.id.imageView);
        loadImageFromUrl(url);
    }

    public void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.drawable.appicon)
                .error(R.drawable.appicon)
                .into(imageView,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });

    }

    public void onBackPressed() {
        Intent intent = new Intent(nz8.this, teamnz.class);
        startActivity(intent);
        finish();
    }
}
