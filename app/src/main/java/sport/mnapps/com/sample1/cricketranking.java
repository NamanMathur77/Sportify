package sport.mnapps.com.sample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class cricketranking extends AppCompatActivity {

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketranking);
        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    public void cricketodiranking(View v){
        Intent intent=new Intent(cricketranking.this,cricketodiranking.class);
        startActivity(intent);
        finish();
    }
    public void crickettestranking(View v){
        Intent intent=new Intent(cricketranking.this,crickettestranking.class);
        startActivity(intent);
        finish();
    }
    public void crickett20ranking(View v){
        Intent intent=new Intent(cricketranking.this,crickett20ranking.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        Intent intent=new Intent(cricketranking.this,cricketmenu.class);
        startActivity(intent);
        finish();
    }
}
