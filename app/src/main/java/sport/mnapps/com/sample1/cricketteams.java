package sport.mnapps.com.sample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class cricketteams extends AppCompatActivity {

    private  AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketteams);
        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void teamaustralia(View view){
        Intent intent=new Intent(cricketteams.this,teamaustralia.class);
        startActivity(intent);
        finish();
    }
    public void teambangladesh(View view){
        Intent intent= new Intent(cricketteams.this,teambangladesh.class);
        startActivity(intent);
        finish();
    }
    public void teamengland(View view)
    {
        Intent intent=new Intent(cricketteams.this,teamengland.class);
        startActivity(intent);
        finish();
    }
    public void teamindia(View view)
    {
        Intent intent=new Intent(cricketteams.this,teamindia.class);
        startActivity(intent);
        finish();
    }
    public void teamnz(View view)
    {
        Intent intent=new Intent(cricketteams.this,teamnz.class);
        startActivity(intent);
        finish();
    }
    public void teampak(View view)
    {
        Intent intent=new Intent(cricketteams.this,teampak.class);
        startActivity(intent);
        finish();
    }
    public void teamsa(View view)
    {
        Intent intent=new Intent(cricketteams.this,teamsa.class);
        startActivity(intent);
        finish();
    }
    public void teamsl(View view)
    {
        Intent intent=new Intent(cricketteams.this,teamsl.class);
        startActivity(intent);
        finish();
    }
    public void teamwi(View view)
    {
        Intent intent=new Intent(cricketteams.this,teamwi.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        Intent intent=new Intent(cricketteams.this,cricketmenu.class);
        startActivity(intent);
        finish();
    }
}
