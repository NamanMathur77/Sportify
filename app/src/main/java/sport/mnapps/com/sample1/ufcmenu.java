package sport.mnapps.com.sample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ufcmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ufcmenu);
    }
    public void ufc(View v){
        Intent intent=new Intent(ufcmenu.this,ufc.class);
        startActivity(intent);
        finish();
    }
    public void titleholders(View v){
        Intent intent=new Intent(ufcmenu.this,ufctitles.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        Intent intent=new Intent(ufcmenu.this,start1.class);
        startActivity(intent);
        finish();
    }
}
