package com.appentus.nutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.cvMealPlan,R.id.cvIntake,R.id.icBack})
    public void submit(View view) {
        switch (view.getId()){

            case R.id.cvMealPlan:
        startActivity(new Intent(Profile.this,ActivityPlan.class));
        break;
            case R.id.cvIntake:
        startActivity(new Intent(Profile.this,FoodDiary.class));
        break;

        case R.id.icBack:
        onBackPressed();
        break;
        default:
            return;
    }

    }

}
