package com.example.myfupo;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myfupo.fragment.BlankFragment1;
import com.example.myfupo.fragment.BlankFragment2;
import com.example.myfupo.fragment.BlankFragment3;
import com.example.myfupo.fragment.BlankFragment4;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    private TabLayout tab;
    private BlankFragment1 blankFragment1;
    private BlankFragment2 blankFragment2;
    private BlankFragment3 blankFragment3;
    private BlankFragment4 blankFragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setIcon(R.mipmap.ic_launcher).setText("首页") );
        tab.addTab(tab.newTab().setIcon(R.mipmap.ic_launcher).setText("首页") );
        tab.addTab(tab.newTab().setIcon(R.mipmap.ic_launcher).setText("首页") );
        tab.addTab(tab.newTab().setIcon(R.mipmap.ic_launcher).setText("首页") );
        blankFragment1 = new BlankFragment1();
        blankFragment2 = new BlankFragment2();
        blankFragment3 = new BlankFragment3();
        blankFragment4 = new BlankFragment4();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame,blankFragment1)
                .add(R.id.frame,blankFragment2)
                .add(R.id.frame,blankFragment3)
                .add(R.id.frame,blankFragment4)
                .show(blankFragment1)
                .hide(blankFragment2)
                .hide(blankFragment3)
                .hide(blankFragment4)
                .commit();
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment1)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment2)
                                .hide(blankFragment1)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment3)
                                .hide(blankFragment2)
                                .hide(blankFragment1)
                                .hide(blankFragment4)
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .show(blankFragment4)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment1)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}