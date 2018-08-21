package com.appentus.nutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        ButterKnife.bind(this);
    }



    @OnClick({R.id.btSubmit,R.id.icBack})
    public  void submit(View view){

        switch (view.getId()) {
            case R.id.btSubmit:
                Intent intent = new Intent(this, ActivityHome.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // call this to finish the current activity
                break;

            case R.id.icBack:
                onBackPressed();
                break;

        }
    }


}
