package sport.mnapps.com.sample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class football1 extends AppCompatActivity {

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football1);
        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void news(View view)
    {
        Intent intent=new Intent(football1.this,football.class);
        startActivity(intent);
        finish();
    }
    public void uefac(View view){
        Intent intent=new Intent(football1.this,uefac.class);
        startActivity(intent);
        finish();
    }
    public void footteam(View view)
    {
        Intent intent=new Intent(football1.this,footballteam.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        Intent intent=new Intent(football1.this,start1.class);
        startActivity(intent);
        finish();
    }
    public void Players(View v){
        Intent intent=new Intent(football1.this,players.class);
        startActivity(intent);
        finish();
    }
}
