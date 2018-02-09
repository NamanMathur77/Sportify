package sport.mnapps.com.sample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class hockey extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hockey);
        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void hockeynews(View view){
        Intent intent=new Intent(hockey.this,hockeynews.class);
        startActivity(intent);
        finish();
    }
    public void hockeyteams(View view){
        Intent intent=new Intent(hockey.this,hocketteams.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        Intent intent=new Intent(hockey.this,start1.class);
        startActivity(intent);
        finish();
    }
}
