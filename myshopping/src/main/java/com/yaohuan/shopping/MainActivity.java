package com.yaohuan.shopping;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yaohuan.shopping.bean.Tab;
import com.yaohuan.shopping.fragment.CartFragment;
import com.yaohuan.shopping.fragment.CatagoryFragment;
import com.yaohuan.shopping.fragment.HomeFragment;
import com.yaohuan.shopping.fragment.HotFragment;
import com.yaohuan.shopping.fragment.MineFragment;
import com.yaohuan.shopping.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater inflater;
    private List<Tab> tabs = new ArrayList<Tab>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    /**
     * 初始化底部菜单栏
     */
    public void initTab() {
        Tab cartTab = new Tab(R.string.cart_name,R.drawable.selector_image_cart, CartFragment.class);
        Tab catagoryTab = new Tab(R.string.catagory_name,R.drawable.selector_image_catagory, CatagoryFragment.class);
        Tab homeTab = new Tab(R.string.home_name, R.drawable.selector_image_home, HomeFragment.class);
        Tab hotTab = new Tab(R.string.hot_name,R.drawable.selector_image_hot, HotFragment.class);
        Tab mineTab = new Tab(R.string.mine_name,R.drawable.selector_image_mine, MineFragment.class);
        tabs.add(cartTab);
        tabs.add(catagoryTab);
        tabs.add(homeTab);
        tabs.add(hotTab);
        tabs.add(mineTab);
        inflater = LayoutInflater.from(MainActivity.this);
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(MainActivity.this, getSupportFragmentManager(), R.id.realtabcontent);
        for (Tab tab : tabs) {
            View view = initIndicate(tab);
            mTabHost.addTab(mTabHost.newTabSpec(getString(tab.getTitle())).setIndicator(view),tab.getFragmentClass(), null);
        }
        //去除分隔线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        //默认选择第一个
        mTabHost.setCurrentTab(0);
    }

    /**
     * 初始化五个菜单栏的图片和文字的样式
     *
     * @param tab
     * @return
     */
    public View initIndicate(Tab tab) {
        View view = inflater.inflate(R.layout.tab_indicate, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_tab);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab);
        imageView.setImageResource(tab.getImage());
        textView.setText(tab.getTitle());
        return view;
    }

}
