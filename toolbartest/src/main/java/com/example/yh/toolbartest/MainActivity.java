package com.example.yh.toolbartest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //设置左侧导航按钮的监听事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "navigation Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        //为toolBar 添加菜单
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId()==R.id.action_settings){
                    Toast.makeText(MainActivity.this, "action_settings clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
