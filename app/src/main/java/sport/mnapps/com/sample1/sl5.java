package sport.mnapps.com.sample1;

/**
 * Created by user on 1/12/2018.
 */



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

public class sl5 extends AppCompatActivity {
    public ImageView imageView;
    private AdView mAdView;
    String url = "https://firebasestorage.googleapis.com/v0/b/sample1-ae95d.appspot.com/o/Screenshot%20(149).png?alt=media&token=81b919a1-9fd4-4c22-a2dc-7afdd53d2dbb";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagedownload);
        imageView = (ImageView) findViewById(R.id.imageView);
        loadImageFromUrl(url);

        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.drawable.appicon)
                .error(R.drawable.appicon)
                .into(imageView, new com.squareup.picasso.Callback() {

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });

    }

    public void onBackPressed() {
        Intent intent = new Intent(sl5.this, teamsl.class);
        startActivity(intent);
        finish();
    }
}
