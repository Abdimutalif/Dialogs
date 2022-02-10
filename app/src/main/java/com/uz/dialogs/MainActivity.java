package com.uz.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.uz.dialogs.databinding.ActivityMainBinding;
import com.uz.dialogs.databinding.DialogBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.alertbtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("bu yerda title");
            builder.setMessage("bu yerda message");
            builder.setCancelable(false);

            builder.setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Positive button clicked", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Negative button clicked", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Neutral button clicked", Toast.LENGTH_SHORT).show();
                }
            });

            builder.show();
        });
        binding.alertListBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String[] a = {"Kotlin", "Java", "Android", "Flutter"};
            boolean[] b = {false, false, false, false};
            builder.setMultiChoiceItems(a, b, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(MainActivity.this, which + "", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            builder.show();
        });
        binding.alertListsingleBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            String[] a={"Portugaliya","Fransiya","Belgiya","Gollandiya"};
            builder.setSingleChoiceItems(a, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, a[which], Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        });
        binding.alertCustomBtn.setOnClickListener(v -> {
          AlertDialog.Builder builder=new AlertDialog.Builder(this);

            DialogBinding dialogBinding=DialogBinding.inflate(getLayoutInflater());
            builder.setView(dialogBinding.getRoot());
            AlertDialog alertDialog = builder.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialogBinding.okButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();
        });
        binding.alertListBtn2.setOnClickListener(v -> {
            MyDialogFragment myDialogFragment=new MyDialogFragment();
            myDialogFragment.show(getSupportFragmentManager(),"dialog");
        });
        binding.dateBtn.setOnClickListener(v -> {
            Date date=new Date();

            Calendar calendar=Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH)+1;
            int year = calendar.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Toast.makeText(MainActivity.this, dayOfMonth+"."+month+"."+year, Toast.LENGTH_SHORT).show();
                }
            },year,month,day);

            datePickerDialog.show();
        });
        binding.timeBtn.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Toast.makeText(MainActivity.this, hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
                }
            },hour,minute,true);
            timePickerDialog.show();
        });

    }
}