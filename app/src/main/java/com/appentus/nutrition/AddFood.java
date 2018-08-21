package com.appentus.nutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddFood extends AppCompatActivity implements adpaterFood.OnItemClicked {

    @BindView(R.id.rvFood)
    RecyclerView rvFood;
    private List<MemberModel> foodList= new ArrayList<>();
    private adpaterFood mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        ButterKnife.bind(this);
setUpRecyclerView();
    }

    public void setUpRecyclerView(){

        mAdapter = new adpaterFood(foodList,AddFood.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,true);
        rvFood.setLayoutManager(mLayoutManager);
        rvFood.setItemAnimator(new DefaultItemAnimator());
        rvFood.setAdapter(mAdapter);

        prepareMovieData();
        mAdapter.setOnClick(this); // Bind the listener

//        addRecyclerViewSwipe(ActivityHome.this,rvMember);
    }
    @Override
    public void onItemClick(int position) {
        // The onClick implementation of the RecyclerView item click
        //ur intent code here
//        startActivity(new Intent(this,AddMember.class));

        Intent i=new Intent(this,AddFoodDetail.class);
        startActivityForResult(i,401);
    }
    private void prepareMovieData() {
        for (int i=0;i<=3;i++) {
            MemberModel member = new MemberModel("Burger", "125.5", "64");
           foodList.add(member);
        }
    }


}
