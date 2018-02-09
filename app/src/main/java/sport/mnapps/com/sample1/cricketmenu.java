package sport.mnapps.com.sample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class cricketmenu extends AppCompatActivity {

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketmenu);
        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void onBackPressed(){
        Intent intent=new Intent(cricketmenu.this,start1.class);
        startActivity(intent);
        finish();
    }
    public void playerinfo(View view){
        Intent intent=new Intent(cricketmenu.this,cricketteams.class);
        startActivity(intent);
        finish();
    }
    public void cricketnews(View view){
        Intent intent=new Intent(cricketmenu.this,cricketnews.class);
        startActivity(intent);
        finish();
    }
    public void cricketranking(View v){
        Intent intent=new Intent(cricketmenu.this,cricketranking.class);
        startActivity(intent);
        finish();
    }
    public void cricbuzz(View v){
        Intent intent=new Intent(cricketmenu.this,cricbuzz.class);
        startActivity(intent);
        finish();
    }

}
