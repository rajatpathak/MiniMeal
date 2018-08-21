package com.appentus.nutrition;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FoodDiary extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    Calendar dateSelected;
    @BindView(R.id.tvDay)
    TextView tvDay;
    String date="";
    String calDate="";
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_diary);
        ButterKnife.bind(this);
        dateSelected = Calendar.getInstance();
        date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        Log.e("Caldate",date);

    }

    private void setDateTimeField() {
        // Get Current Date

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        if ((monthOfYear + 1)<9){

                            calDate=dayOfMonth + "-0" + (monthOfYear + 1) + "-" + year;
                        }
                        else
                        {
                            calDate=dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        }

                        if (date.equals(calDate)){
                            tvDay.setText("Today");
                        }
                        else {
                            tvDay.setText(calDate);
                        }
                        Log.e("Caldate",calDate);
                        Log.e("Caldate",date);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    @OnClick({R.id.tvViewGraph,R.id.icCalendar})
    public void submit(View view) {
        switch (view.getId()){

            case R.id.tvViewGraph:
//                startActivity(new Intent(FoodDiary.this,FoodDairyGraph.class));
                break;

            case R.id.icCalendar:
                setDateTimeField();
                break;

            default:
                return;
        }

    }



}
