package sport.mnapps.com.sample1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSignin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent (getApplicationContext(),start1.class));

        }
        editTextEmail=(EditText)findViewById(R.id.edittextemail);
        editTextPassword=(EditText)findViewById(R.id.edittextpassword);
        buttonSignin=(Button)findViewById(R.id.buttonsignin);
        textViewSignup=(TextView)findViewById(R.id.textViewSignup);
        progressDialog=new ProgressDialog(this);

        buttonSignin.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }

    private  void userLogin(){
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();


        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter the Password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Loging In...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                   progressDialog.dismiss();

                   if(task.isSuccessful()){
                       finish();
                       startActivity(new Intent (getApplicationContext(),start1.class));
                   }
                   else
                       Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    @Override
    public void onClick(View view) {
        if(view==buttonSignin){
            userLogin();
        }
        if(view==textViewSignup){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
