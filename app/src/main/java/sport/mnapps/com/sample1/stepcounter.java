package sport.mnapps.com.sample1;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class stepcounter extends AppCompatActivity implements SensorEventListener, StepListener {
    private TextView textView;
    public TextView TvSteps;
    public TextView TvCal;
    public TextView TvDist;
    private Button BtnStart;
    private Button BtnStop;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    private float calories;
    private float distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepcounter);

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        TvSteps = (TextView) findViewById(R.id.tv_steps);
        TvCal=(TextView)findViewById(R.id.tv_cal);
        TvDist=(TextView)findViewById(R.id.tv_dist);
        BtnStart = (Button) findViewById(R.id.btn_start);
        



        BtnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                numSteps = 0;
                sensorManager.registerListener(stepcounter.this, accel, SensorManager.SENSOR_DELAY_FASTEST);
                BtnStart.setText("Restart");
                TvDist.setText("Distance Covered (in km) :- 0");
                TvCal.setText("Calories Burned :- 0");
                TvSteps.setText(TEXT_NUM_STEPS+0);
                BtnStart.setBackgroundColor(Color.parseColor("#F44336"));

            }
        });






    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
        calories= (float) (numSteps*0.045);
        TvCal.setText("Calories Burned :- "+calories);

        distance= (float) (numSteps*0.0005);
        TvDist.setText("Distance Covered (in km) :- "+distance);
    }
    public void onBackPressed(){
        Intent intent= new Intent(stepcounter.this,start1.class);
        startActivity(intent);
        finish();
    }



}
