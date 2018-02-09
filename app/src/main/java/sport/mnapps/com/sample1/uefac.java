package sport.mnapps.com.sample1;

/**
 * Created by user on 1/12/2018.
 */

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class uefac extends AppCompatActivity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String newAU = "Mozilla/5.0(X11; U;Linux i686; en-US;rv:1.9.0.4) Gecko/20110101 Firefox/4.0";

        setContentView(R.layout.activity_football);


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
        web.loadUrl("http://www.goal.com/en/uefa-champions-league/4oogyu6o156iphvdvphwpck10");
        web.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();

        } else {
            Intent main = new Intent(uefac.this, football1.class);
            startActivity(main);
        }
    }
}
