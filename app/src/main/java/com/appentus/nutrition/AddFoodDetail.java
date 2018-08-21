package com.appentus.nutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddFoodDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_detail);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btSubmit,R.id.icBack})
    public  void submit(View view){


            switch (view.getId()) {
                case R.id.btSubmit:
                    startActivity(new Intent(AddFoodDetail.this, ActivityConfirmation.class));
                    break;

                case R.id.icBack:
                   onBackPressed();
                    break;

            }
    }
}
