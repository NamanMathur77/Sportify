package sport.mnapps.com.sample1;

import android.app.ActionBar;
import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.ads.AdRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class start1 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button ButtonLogout;
    private FirebaseAuth mAuth;
    private AdView mAdView;
    TextView textview;
    private DatabaseReference mDatabaseRef;
    private List<ImageUpload> imgList;
    private ListView lv;
    private ImageListAdapter adapter;
    private ProgressDialog progressDialog;
    public static final String FB_STORAGE_PATH="image/";
    public static final String FB_DATABASE_PATH="image";

    private InterstitialAd mInterstitialAd;
    ImageView imageView1;
    DatabaseReference mRootRef= FirebaseDatabase.getInstance().getReference();
    DatabaseReference mConditionRef=mRootRef.child("condition");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start1);

        imgList=new ArrayList<>();
        lv=(ListView)findViewById(R.id.listViewImage);

        progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Please wait loading latest news...");
        progressDialog.show();

        mDatabaseRef= FirebaseDatabase.getInstance().getReference(FB_DATABASE_PATH);
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    ImageUpload img= snapshot.getValue(ImageUpload.class);
                    imgList.add(img);
                }

                adapter = new ImageListAdapter(start1.this,R.layout.image_item, imgList);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();

            }
        });

        MobileAds.initialize(this,"ca-app-pub-4650541738292698~6739708950");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mAuth=FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,login.class));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(start1.this,stepcounter.class);
                startActivity(intent);
                finish();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FirebaseUser user=mAuth.getCurrentUser();

    }//end of onCreate
    


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mAuth.signOut();
            finish();
            startActivity(new Intent(this,login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cricket) {
            Intent intent=new Intent(start1.this,cricketmenu.class);
            startActivity(intent);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_football) {
            Intent intent=new Intent(start1.this,football1.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_hockey) {
            Intent intent=new Intent(start1.this,hockey.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_ufc) {
            Intent intent=new Intent(start1.this,ufcmenu.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.wwe) {
            Intent intent=new Intent(start1.this,wwe.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.basketball) {
            Intent intent=new Intent(start1.this,bb.class);
            startActivity(intent);
            finish();

        }
        else if(id==R.id.SD){
            Intent intent=new Intent(start1.this,sd.class);
            startActivity(intent);
            finish();
        }
        else if(id==R.id.runner){
            Intent intent=new Intent(start1.this,stepcounter.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    }
