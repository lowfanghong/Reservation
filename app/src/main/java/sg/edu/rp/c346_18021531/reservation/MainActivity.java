package sg.edu.rp.c346_18021531.reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText etName,etMobile,etGroupSize;
  CheckBox cbSmoking;
  Button btnSubmit, btnDefault,btnReset;
    DatePicker dp;
    TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editText10);
        etMobile = findViewById(R.id.editText2);
        etGroupSize = findViewById(R.id.editText3);
        cbSmoking = findViewById(R.id.checkBox2);
        btnSubmit = findViewById(R.id.button);
        btnDefault = findViewById(R.id.button3);
        btnReset = findViewById(R.id.button2);
        tp = findViewById(R.id.timePicker);
        tp.setIs24HourView(true);
        dp = findViewById(R.id.datePicker);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        String name = etName.getText().toString();
        String mb = etMobile.getText().toString();
        String GS = etGroupSize.getText().toString();
                tp.setIs24HourView(true);
                Integer currenthour = tp.getCurrentHour();
                Integer currentminute  = tp.getCurrentMinute();
                Integer day = dp.getDayOfMonth();
                Integer month = dp.getMonth() + 1;
                Integer year = dp.getYear();

                if (cbSmoking.isChecked()){
                    Toast.makeText(MainActivity.this,
                            name + " has booked a smoking area with "
                                    + GS +" people on "+
                                    day + "/"+ month + "/" +
                                    year +" with timing of "+ currenthour + ":"
                                    + currentminute + "." + name
                                    +"'s mobile phone number is " + mb,
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,
                            name + " has booked a non-smoking area with " + GS
                                    +" people on "+
                                    day + "/"+ month + "/" +
                                    year +" with timing of "+ currenthour + ":"
                                    + currentminute + "." + name
                                    +"'s mobile phone number is " + mb,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,5,1);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            cbSmoking.setChecked(false);
            etName.setText("");
                etMobile.setText("");
                etGroupSize.setText("");
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,5,1);
            }
        });
    }
}
