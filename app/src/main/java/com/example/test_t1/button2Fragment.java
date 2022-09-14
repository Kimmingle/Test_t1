package com.example.test_t1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import androidx.core.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.test_t1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;

public class button2Fragment extends Fragment
{
    private String fac_line;
    private View view;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    MainActivity mainActivity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        System.out.println("2번 프래그먼트실행");
         mainActivity = new MainActivity();
        view= inflater.inflate(R.layout.fragment_btn2,container,false);

        button1 =(Button) view.findViewById(R.id.button1);
        button2 =(Button) view.findViewById(R.id.button2);
        button3 =(Button) view.findViewById(R.id.button3);
        button4 =(Button) view.findViewById(R.id.button4);

        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView3 = (TextView) view.findViewById(R.id.textView3);

        if(getArguments()!= null)
        {
            fac_line = getArguments().getString("line");

            switch (fac_line)
            {
                case "A1":
                    change_color(button1);
                    break;
                case "A2":
                    change_color(button2);
                    break;
                case "A3":
                    change_color(button3);
                    break;
                case "A4":
                    change_color(button4);
                    break;

                default:
                    break;
            }
        }


        BottomNavigationView bottomNavigationView = view.findViewById(R.id.nav_view);

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //1.프래그먼트생성,transcation객체 설정, replace하고 commit
                //Navigation.findNavController(view).navigate(R.id.action_navigation_btn2_to_navigation_btn3); //여기 그냥 3으로 이동..
                //bottomNavigationView.getMenu().findItem(R.id.navigation_btn3).setChecked(true); 메뉴를 선택한효과 -> 이미지만
//               System.out.println("확인"+bottomNavigationView.getMaxItemCount());

//               bottomNavigationView.performClick(); //해당view를 클릭한것같은 효과



            }
        });

        //서버로 부터 동작시간을 계산하고 타이머를 통해 색이 바뀐시점부터 다시 바뀐시점을 기록하여 표기
        TextView line_1 = view.findViewById(R.id.A1_num);
        ProgressBar A1_bar = view.findViewById(R.id.line1_progressbar);
        TextView line_2 = view.findViewById(R.id.A2_num);
        ProgressBar A2_bar = view.findViewById(R.id.line2_progressbar);
        TextView line_3 = view.findViewById(R.id.A3_num);
        ProgressBar A3_bar = view.findViewById(R.id.line3_progressbar);
        TextView line_4 = view.findViewById(R.id.A4_num);
        ProgressBar A4_bar = view.findViewById(R.id.line4_progressbar);

        Handler handler = new Handler();
        new Thread(new Runnable() {
            int i =0;
            int a =0;
            int b =0;
            int c =0;
            int d =0;

            @Override
            public void run()
            {

                while(i< 100)
                {
                    handler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            line_1.setText( a+"%");
                            line_2.setText( b+"%");
                            line_3.setText( c+"%");
                            line_4.setText( d+"%");

                            A1_bar.setProgress(a);
                            A2_bar.setProgress(b);
                            A3_bar.setProgress(c);
                            A4_bar.setProgress(d);

                            if (a<90) {a++;}
                            if(b<92) {b++;}
                            if(c<94){c++;}
                            if(d<91){d++;}
                            i++;
                        }

                    });

                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (Exception e)
                    {}
                }
            }
        }).start();

        return view;
    }


    //색바꾸는 메서드
    public void change_color(Button btn)
    {
        btn.setTextColor(Color.BLUE);
    }

    //시간 가동률 계산 메서드
    public int cal_time(float run_time, float stop_time)
    {
        int result;
        float temp = 0;
        temp= (run_time -stop_time)/run_time *100 ; //본래 돌앗어야하는시간대비 실제로 돌아간 시간
        result = (int)temp;
        return result;
    }

}
