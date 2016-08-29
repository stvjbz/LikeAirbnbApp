package com.stvjbz.likeairbnbapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.WindowCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Locale;

public class RoomsActivity extends AppCompatActivity {

    private ColorDrawable actionbarBackground; // アクションバー背景
    private TextView title; // アクションバーに表示するタイトル
    private ActionBar actionBar; // アクションバーに表示するタイトル
    private Boolean isTop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(WindowCompat.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_rooms);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            // アクションバーの背景色を設定
            actionbarBackground = new ColorDrawable(Color.parseColor("#00ee00"));
            actionbarBackground.setAlpha(0); // 背景を透明に。
            actionBar.setHideOnContentScrollEnabled(true);
            actionBar.setShowHideAnimationEnabled(true);
            actionBar.setBackgroundDrawable(actionbarBackground);
            actionBar.setDisplayHomeAsUpEnabled(true);

            // タイトル
            String title = "";
            int titleColor = Color.WHITE;
            String htmlColor = String.format(Locale.US, "#%06X", (0xFFFFFF & Color.argb(0, Color.red(titleColor), Color.green(titleColor), Color.blue(titleColor))));
            String titleHtml = "<font color=\"" + htmlColor + "\">" + title + "</font>";
            actionBar.setTitle(Html.fromHtml(titleHtml));
            // アップボタン
            final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
            upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
            actionBar.setHomeAsUpIndicator(upArrow);
        }

        final NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.contents_nested_scroll_view);
        assert nestedScrollView != null;
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(){
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY >= 300) {
                    // 背景色
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                    // タイトル
                    String title = "";
                    int titleColor = Color.BLACK;
                    String htmlColor = String.format(Locale.US, "#%06X", (0xFFFFFF & Color.argb(0, Color.red(titleColor), Color.green(titleColor), Color.blue(titleColor))));
                    String titleHtml = "<font color=\"" + htmlColor + "\">" + title + "</font>";
                    actionBar.setTitle(Html.fromHtml(titleHtml));
                    // アップボタン
                    final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
                    upArrow.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
                    actionBar.setHomeAsUpIndicator(upArrow);
                    // メニューアイコン用
                    isTop = false;
                } else {
                    // アクションバーの背景色を設定
                    actionbarBackground = new ColorDrawable(Color.parseColor("#00ee00"));
                    actionbarBackground.setAlpha(0); // 背景を透明に。
                    actionBar.setBackgroundDrawable(actionbarBackground);

                    // タイトル
                    String title = "";
                    int titleColor = Color.WHITE;
                    String htmlColor = String.format(Locale.US, "#%06X", (0xFFFFFF & Color.argb(0, Color.red(titleColor), Color.green(titleColor), Color.blue(titleColor))));
                    String titleHtml = "<font color=\"" + htmlColor + "\">" + title + "</font>";
                    actionBar.setTitle(Html.fromHtml(titleHtml));
                    // アップボタン
                    final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
                    upArrow.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                    actionBar.setHomeAsUpIndicator(upArrow);
                    // メニューアイコン用
                    isTop = true;
                }
                invalidateOptionsMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rooms, menu);
        if (isTop) {
            menu.getItem(0).setIcon(R.drawable.ic_action_bar_share_your_link_white);
            menu.getItem(1).setIcon(R.drawable.ic_action_bar_wish_list_white);
        } else {
            menu.getItem(0).setIcon(R.drawable.ic_action_bar_share_your_link);
            menu.getItem(1).setIcon(R.drawable.ic_action_bar_wish_list);
        }
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
