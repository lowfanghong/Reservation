package sg.edu.rp.c346_18021531.reservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
  EditText etName,etMobile,etGroupSize,etDay,etTime;
  CheckBox cbSmoking;
  Button btnSubmit, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editText10);
        etMobile = findViewById(R.id.editText2);
        etGroupSize = findViewById(R.id.editText3);
        etDay = findViewById(R.id.editTextday);
        etTime = findViewById(R.id.editTextTime);
        cbSmoking = findViewById(R.id.checkBox2);
        btnSubmit = findViewById(R.id.button);
        btnReset = findViewById(R.id.button2);

     etDay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                 @Override
                 public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                     etDay.setText("Date:" + dayOfMonth + "/" + (month+1) + "/" + year);
                 }
             };
             Calendar CA = Calendar.getInstance();
             DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                     myDateListener,CA.get(Calendar.YEAR),CA.get(Calendar.MONTH),
                     CA.get(Calendar.DAY_OF_MONTH));
             myDateDialog.show();
         }
     });
     etTime.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             TimePickerDialog.OnTimeSetListener myTimeListener = new
                     TimePickerDialog.OnTimeSetListener() {
                         @Override
                         public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                             etTime.setText("Time: " + hourOfDay +":" + minute);
                         }
                     };

             Calendar CA = Calendar.getInstance();
             TimePickerDialog myTimePickerDialog =
                     new TimePickerDialog(MainActivity.this,
                             myTimeListener,CA.get(Calendar.HOUR),CA.get(Calendar.MINUTE),
                             false);
             myTimePickerDialog.show();
         }
     });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        String name = etName.getText().toString();
        String mb = etMobile.getText().toString();
        String GS = etGroupSize.getText().toString();
        String day = etDay.getText().toString();
        String time = etTime.getText().toString();


                if (cbSmoking.isChecked()){
                    LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService
                            (Context.LAYOUT_INFLATER_SERVICE);
                    View viewDialog3 = inflater.inflate(R.layout.row,null);
                    final TextView tvName = viewDialog3.findViewById(R.id.textViewName);
                    final TextView tvSmoking = viewDialog3.findViewById(R.id.textViewSmoking);
                    final TextView tvSize = viewDialog3.findViewById(R.id.textViewSize);
                    final TextView tvDate = viewDialog3.findViewById(R.id.textViewDate);
                    final TextView tvTime = viewDialog3.findViewById(R.id.textViewTime);
                    tvName.setText("Name: " + name);
                    tvSmoking.setText("Smoking: Smoking ");
                    tvSize.setText("Size: " + GS);
                    tvDate.setText("Date: " + day);
                    tvTime.setText("Time: " + time);
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder
                            (MainActivity.this);
                    myBuilder.setView(viewDialog3);
                    myBuilder.setTitle("Confirm Your Order");
                    myBuilder.setCancelable(false);
                    myBuilder.setPositiveButton("confirm",null);
                    myBuilder.setNeutralButton("Cancel",null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();


                }else{
                    LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService
                            (Context.LAYOUT_INFLATER_SERVICE);
                    View viewDialog3 = inflater.inflate(R.layout.row,null);
                    final TextView tvName = viewDialog3.findViewById(R.id.textViewName);
                    final TextView tvSmoking = viewDialog3.findViewById(R.id.textViewSmoking);
                    final TextView tvSize = viewDialog3.findViewById(R.id.textViewSize);
                    final TextView tvDate = viewDialog3.findViewById(R.id.textViewDate);
                    final TextView tvTime = viewDialog3.findViewById(R.id.textViewTime);
                    tvName.setText("Name: " + name);
                    tvSmoking.setText("Smoking: Non-Smoking ");
                    tvSize.setText("Size: " + GS);
                    tvDate.setText("Date: " + day);
                    tvTime.setText("Time: " + time);
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder
                            (MainActivity.this);
                    myBuilder.setView(viewDialog3);
                    myBuilder.setTitle("Confirm Your Order");
                    myBuilder.setCancelable(false);
                    myBuilder.setPositiveButton("confirm",null);
                    myBuilder.setNeutralButton("Cancel",null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();

                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            cbSmoking.setChecked(false);
            etName.setText("");
                etMobile.setText("");
                etGroupSize.setText("");
                etDay.setText("");
                etTime.setText("");

            }
        });
    }
}
