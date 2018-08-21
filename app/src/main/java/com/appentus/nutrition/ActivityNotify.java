package com.appentus.nutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityNotify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btAllow)
    public void submit() {
        startActivity(new Intent(ActivityNotify.this,ActivityHome.class));
    }
}
