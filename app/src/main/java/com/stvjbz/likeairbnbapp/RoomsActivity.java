package com.stvjbz.likeairbnbapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

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

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHideOnContentScrollEnabled(true);
            actionBar.setShowHideAnimationEnabled(true);
            actionBar.setBackgroundDrawable(actionbarBackground);
            actionBar.setCustomView(title);
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setTitle("テスト・テスト");

            // タイトル
            String title = "宇都宮";
            int titleColor = Color.BLACK;
            String htmlColor = String.format(Locale.US, "#%06X", (0xFFFFFF & Color.argb(0, Color.red(titleColor), Color.green(titleColor), Color.blue(titleColor))));
            String titleHtml = "<font color=\"" + htmlColor + "\">" + title + "</font>";
            actionBar.setTitle(Html.fromHtml(titleHtml));
            // アップボタン
            final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            upArrow.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
            actionBar.setHomeAsUpIndicator(upArrow);
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
