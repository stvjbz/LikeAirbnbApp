package com.stvjbz.likeairbnbapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RoomsActivity extends AppCompatActivity {

    private ColorDrawable actionbarBackground; // アクションバー背景
    private TextView title; // アクションバーに表示するタイトル

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(WindowCompat.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_rooms);

        // アクションバーの背景色を設定
        actionbarBackground = new ColorDrawable(Color.parseColor("#00ee00"));
        title = new TextView(this);

        // 背景を透明に。
        actionbarBackground.setAlpha(0);

        title.setText(R.string.app_name);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER_VERTICAL);
        // タイトルも透明にする
        //title.setAlpha(0);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHideOnContentScrollEnabled(true);
            actionBar.setShowHideAnimationEnabled(true);
            actionBar.setBackgroundDrawable(actionbarBackground);
            actionBar.setCustomView(title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rooms, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_share_your_link:
            case R.id.action_wish_list:
        }
        return super.onOptionsItemSelected(item);
    }
}
