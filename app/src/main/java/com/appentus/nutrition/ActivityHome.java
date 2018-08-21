package com.appentus.nutrition;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityHome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,adpaterMember.OnItemClicked {

    private List<MemberModel> memberList= new ArrayList<>();
    private adpaterMember mAdapter;

    @BindView(R.id.rvFMember)RecyclerView rvMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setUpToolBar();




        setUpRecyclerView();

    }

    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Dashboard");
        toolbar.setTitleTextColor(Color.BLACK);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.setHomeAsUpIndicator(R.drawable.ic_menu_gallery);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    public void setUpRecyclerView(){

        mAdapter = new adpaterMember(memberList,ActivityHome.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvMember.setLayoutManager(mLayoutManager);
        rvMember.setItemAnimator(new DefaultItemAnimator());
        rvMember.setAdapter(mAdapter);

        prepareMovieData();
        mAdapter.setOnClick(this); // Bind the listener

        addRecyclerViewSwipe(ActivityHome.this,rvMember);

    }

    @Override
    public void onItemClick(int position) {
        // The onClick implementation of the RecyclerView item click
        //ur intent code here
//        startActivity(new Intent(this,AddMember.class));

        Intent i=new Intent(this,Profile.class);
        startActivity(i);
    }


    public void addRecyclerViewSwipe(Context context,RecyclerView recyclerView){

        SwipeHelper swipeHelper = new SwipeHelper(context, rvMember) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Delete",
                        0,
                        Color.parseColor("#FF3C30"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                // TODO: onDelete
                                removeAt(pos);

                            }
                        }
                ));
            }
        };

    }

    private void removeAt(int pos) {
        memberList.remove(pos);
        mAdapter.notifyItemRemoved(pos);
        mAdapter.notifyItemRangeChanged(pos, memberList.size());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==200&&resultCode == RESULT_OK){
            Log.e("activity", " recreate"+data.getStringExtra("hii"));
            recreate();
        }
    }

    private void prepareMovieData() {
        for (int i=0;i<=3;i++) {
            MemberModel member = new MemberModel("John", "125.5", "64");
            memberList.add(member);
        }

        Log.e("memebr",memberList.size()+"");
        MemberModel movie = new MemberModel("custom", "", "");
        memberList.add(movie);
        Log.e("memebr",memberList.size()+"");
    }

    @OnClick(R.id.cvMemberAdd)
    public void submit() {
        startActivity(new Intent(ActivityHome.this,AddMember.class));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the ActivityHome/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gallery) {
            // Handle the camera action
            startActivity(new Intent(ActivityHome.this,AddFood.class));
        } else if (id == R.id.nav_camera) {
            startActivity(new Intent(ActivityHome.this,Profile.class));
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
