package com.example.test_t1;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<issue_data> issueDataList;
    BottomNavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        File fileFile = getFilesDir();
        String getFile = fileFile.getPath();

//        System.out.println("현재경로" + getFile); ///data/user/0/com.example.test_t1/files



        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);
//        appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_btn1, R.id.navigation_btn2, R.id.navigation_btn3).build();
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_btn1, R.id.navigation_btn2, R.id.navigation_btn4).build();

        navController = Navigation.findNavController(this,R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController); //navigationUI가 객체가아님


//        getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment_activity_main, new button1Fragment()).commit();
//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId())
//                {
//                    case R.id.navigation_btn1:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, new button1Fragment()).commit();
//                        break;
//                    case R.id.navigation_btn2:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, new button2Fragment()).commit();
//                        break;
//                    case R.id.navigation_btn3:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, new button3Fragment()).commit();
//                        break;
//
//                }
//                return false;
//            }
//        });
    }

    //네비 3선택
    public void selected3()
    {
        System.out.println("선택 메서드 작동");
        navigationView.setSelectedItemId(R.id.navigation_btn4); //해당항목을 누른것과 같은효과



//                //밑에꺼는 아이템이 선택됬을때의 메서드를 덧붙이는거 같은데
//                navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener()
//                {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item)
//                    {
//                        return false;
//                    }
//                });



    }


    protected void change(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }



}