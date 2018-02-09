package sport.mnapps.com.sample1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile extends AppCompatActivity implements View.OnClickListener{
    private Button ButtonLogout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mAuth=FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,login.class));
        }
        FirebaseUser user=mAuth.getCurrentUser();
        ButtonLogout=(Button)findViewById(R.id.buttonLogOut);
        ButtonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==ButtonLogout){
            mAuth.signOut();
            finish();
            startActivity(new Intent(this,login.class));
        }
    }
}
