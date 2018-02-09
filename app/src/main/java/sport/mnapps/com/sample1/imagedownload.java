package sport.mnapps.com.sample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class imagedownload extends AppCompatActivity {
    public ImageView imageView;
    private static final String TAG = "MainActivity";

    private AdView mAdView;
    String url="https://firebasestorage.googleapis.com/v0/b/sample1-ae95d.appspot.com/o/aa.png?alt=media&token=56e2c9ee-1bb6-4523-aa96-5fb1f9d18367";


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
    public void onBackPressed(){
        Intent intent=new Intent(imagedownload.this,teamaustralia.class);
        startActivity(intent);
        finish();
    }
}
