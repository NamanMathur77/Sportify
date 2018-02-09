package sport.mnapps.com.sample1;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class cricbuzz extends AppCompatActivity {
    private WebView web;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String newAU = "Mozilla/5.0(X11; U;Linux i686; en-US;rv:1.9.0.4) Gecko/20110101 Firefox/4.0";
        setContentView(R.layout.activity_cricbuzz);
        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        web = (WebView) findViewById(R.id.web);
        web.getSettings().setUserAgentString(newAU);

        WebSettings WebSettings = web.getSettings();
        WebSettings.setJavaScriptEnabled(true);
        WebSettings.setBuiltInZoomControls(true);
        WebSettings.setSupportZoom(true);
        web.getSettings().setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            web.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        } else {
            web.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        web.loadUrl("http://www.cricbuzz.com/");
        web.setWebViewClient(new WebViewClient());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cricbuzz, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.reload) {
            web.reload();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();

        } else {
            Intent main = new Intent(cricbuzz.this, cricketmenu.class);
            startActivity(main);
        }
    }
    }

