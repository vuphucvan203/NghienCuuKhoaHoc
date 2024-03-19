package com.example.nghiencuukhoahoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nghiencuukhoahoc.Adapter.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView TvWeather, TvTemperature,
            TvHumidityAndWind;
    private ImageView imgWeather,avartar;
    private ImageButton img_btn_Logout;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FragmentAdapter fragmentAdapter;
    Dialog dialog;

    String weather;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidgets();
        getTabLayOut();
    }
    private void InitWidgets() {
        img_btn_Logout = findViewById(R.id.img_btn_logOut);
        imgWeather = findViewById(R.id.imgforcast);
        TvWeather = findViewById(R.id.TvWeather);
        TvTemperature = findViewById(R.id.TvTemperature);
        TvHumidityAndWind = findViewById(R.id.TvHumidityAndWind);
        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewPage2);
        avartar = findViewById(R.id.avatar);

    }
    private void getTabLayOut() {
        tabLayout.addTab(tabLayout.newTab().setText("All Room"));
        tabLayout.addTab(tabLayout.newTab().setText("Bed Room"));
        tabLayout.addTab(tabLayout.newTab().setText("Living Room"));
        tabLayout.addTab(tabLayout.newTab().setText("Stream Room"));
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}