package sport.mnapps.com.sample1;

/**
 * Created by user on 1/7/2018.
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class stevesmith extends AppCompatActivity {
    public ImageView imageView;
    String url="https://firebasestorage.googleapis.com/v0/b/sample1-ae95d.appspot.com/o/ss.png?alt=media&token=17836916-2ecd-44cf-8280-9a518b0f10b4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagedownload);
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
    public void onBackPressed(){
        Intent intent=new Intent(stevesmith.this,teamaustralia.class);
        startActivity(intent);
        finish();
    }
}
