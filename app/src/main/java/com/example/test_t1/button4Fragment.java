package com.example.test_t1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class button4Fragment extends Fragment {
    private View view;
    private View fac_view1;
    private View fac_view2;
    private View fac_view3;
    private View fac_view4;

    private ImageView A1_f1_r;
    private ImageView A1_f1_b;
    private ImageView A1_f2_r;
    private ImageView A1_f2_b;

    private ImageView A2_f1_r;
    private ImageView A2_f1_b;
    private ImageView A2_f2_r;
    private ImageView A2_f2_b;

    private ImageView A3_f1_r;
    private ImageView A3_f1_b;
    private ImageView A3_f2_r;
    private ImageView A3_f2_b;

    private ImageView A4_f1_r;
    private ImageView A4_f1_b;
    private ImageView A4_f2_r;
    private ImageView A4_f2_b;

    private View expendedfac;

    private Button back_button;

    private Animator currentAnimator;
    private int shortAnimationDuration;

    LineChart chart;
    ArrayList<issue_data> issueDataList;
    int i =0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_btn4, container, false);

        fac_view1 = (View) view.findViewById(R.id.A1_layout);
        fac_view2 = (View) view.findViewById(R.id.A2_layout);
        fac_view3 = (View) view.findViewById(R.id.A3_layout);
        fac_view4 = (View) view.findViewById(R.id.A4_layout);

        A1_f1_r = (ImageView) view.findViewById(R.id.imageView_F1_Red1_1);
        A1_f1_b = (ImageView) view.findViewById(R.id.imageView_F1_Blue1_1);
        A1_f2_r = (ImageView) view.findViewById(R.id.imageView_F2_Red1_2);
        A1_f2_b = (ImageView) view.findViewById(R.id.imageView_F2_Blue1_2);

        A1_f1_r = (ImageView) view.findViewById(R.id.imageView_F1_Red2_1);
        A1_f1_b = (ImageView) view.findViewById(R.id.imageView_F1_Blue2_1);
        A1_f2_r = (ImageView) view.findViewById(R.id.imageView_F2_Red2_2);
        A1_f2_b = (ImageView) view.findViewById(R.id.imageView_F2_Blue2_2);

        A1_f1_r = (ImageView) view.findViewById(R.id.imageView_F1_Red3_1);
        A1_f1_b = (ImageView) view.findViewById(R.id.imageView_F1_Blue3_1);
        A1_f2_r = (ImageView) view.findViewById(R.id.imageView_F2_Red3_2);
        A1_f2_b = (ImageView) view.findViewById(R.id.imageView_F2_Blue3_2);

        A1_f1_r = (ImageView) view.findViewById(R.id.imageView_F1_Red4_1);
        A1_f1_b = (ImageView) view.findViewById(R.id.imageView_F1_Blue4_1);
        A1_f2_r = (ImageView) view.findViewById(R.id.imageView_F2_Red4_2);
        A1_f2_b = (ImageView) view.findViewById(R.id.imageView_F2_Blue4_2);

        expendedfac= (View)view.findViewById(R.id.expanded_fac); //확장된 공장그림 프레임 레이아웃
        back_button=(Button) view.findViewById(R.id.back_button);

        final ImageView expanded_fac_ImageView = (ImageView) view.findViewById(R.id.expanded_fac_image); //확장된 이미지
        final ImageView expanded_f1_b_ImageView =  (ImageView) view.findViewById(R.id.imageView_F1_Blue);
        final ImageView expanded_f2_b_ImageView =  (ImageView) view.findViewById(R.id.imageView_F2_Blue);
        final TextView expanded_text = (TextView) view.findViewById(R.id.textView);

        i=0;
        issueDataList = new ArrayList<issue_data>();
        chart = (LineChart) view.findViewById(R.id.data_chart);
        chart.setDrawGridBackground(true);
        chart.setBackgroundColor(Color.WHITE);
        chart.setGridBackgroundColor(Color.WHITE);

// description text
        chart.getDescription().setEnabled(false);
//        Description des = chart.getDescription();
//        des.setEnabled(true);
//        des.setText("Factory DATA");
//        des.setTextSize(15f);
//        des.setTextColor(Color.BLACK);

// touch gestures (false-비활성화)
        chart.setTouchEnabled(false);

// scaling and dragging (false-비활성화)
        chart.setDragEnabled(false);
        chart.setScaleEnabled(false);
//auto scale
        chart.setAutoScaleMinMaxEnabled(false);

// if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);
        //chart.setVisibleYRange(0.03f,0.03f, YAxis.AxisDependency.LEFT);//
//X축
        chart.getXAxis().setDrawGridLines(true); //??
        chart.getXAxis().setDrawAxisLine(true); //그래프외각선
        chart.getXAxis().setEnabled(true); //x선 표기
        chart.getXAxis().setDrawGridLines(false); //단위선 표기?
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        //        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);


//Legend
        Legend l = chart.getLegend();
        l.setEnabled(true);
        l.setFormSize(10f); // set the size of the legend forms/shapes
        l.setTextSize(12f);
        l.setTextColor(Color.BLACK);

//Y축
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setEnabled(true);
        leftAxis.setTextColor(getResources().getColor(R.color.black));
        leftAxis.setDrawGridLines(false); //단위선
        leftAxis.setGridColor(getResources().getColor(R.color.purple_700));


        //leftAxis.setDrawLimitLinesBehindData(true);

        //상한선 조정
        LimitLine upper_limit = new LimitLine(2f, "Max Value");
        upper_limit.setLineWidth(2f);
        upper_limit.enableDashedLine(10f, 10f, 0f);
        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        upper_limit.setTextSize(10f);

        leftAxis.setDrawLimitLinesBehindData(true);
        leftAxis.addLimitLine(upper_limit);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);

// don't forget to refresh the drawing
        chart.invalidate();

        fac_view1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                zoomImageFromThumb(fac_view1,expendedfac);
                expanded_text.setText("A1공장설비");
            }
        });

        fac_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                zoomImageFromThumb(fac_view2,expendedfac); //해당 이미지로 바꾼다.
                expanded_text.setText("A2공장설비");

            }
        });

        fac_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                zoomImageFromThumb(fac_view3,expendedfac); //해당 이미지로 바꾼다.
                expanded_text.setText("A3공장설비");

            }
        });

        fac_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                zoomImageFromThumb(fac_view4,expendedfac); //해당 이미지로 바꾼다.
                expanded_text.setText("A4공장설비");
            }
        });
        shortAnimationDuration = getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_medium_1); //애니동작시간


        for(int j=0;j<10;j++)
        {
            addEntry(1);
            addEntry(2);
        }

        return view;
    }

    public void addEntry(double num) {

        LineData data = chart.getData();

        if (data == null) {
            data = new LineData();
            chart.setData(data);
        }

        ILineDataSet set = data.getDataSetByIndex(0);
        // set.addEntry(...); // can be called as well

        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }

        data.addEntry(new Entry((float)set.getEntryCount(), (float)num), 0);
        data.notifyDataChanged();

        // let the chart know it's data has changed
        chart.notifyDataSetChanged();

        chart.setVisibleXRangeMaximum(30);
        // this automatically refreshes the chart (calls invalidate())
        chart.moveViewTo(data.getXMax(), 50f, YAxis.AxisDependency.LEFT);
    }

    private LineDataSet createSet()
    {
        LineDataSet set = new LineDataSet(null, "설비 값");
        set.setLineWidth(1f);
        set.setDrawValues(false);
        set.setValueTextColor(getResources().getColor(R.color.black));
        set.setColor(getResources().getColor(R.color.black));
        set.setMode(LineDataSet.Mode.LINEAR);
        set.setDrawCircles(false);
        set.setHighLightColor(Color.rgb(190, 190, 190));

        return set;
    }


    private void zoomImageFromThumb(final View thumbView , View expeded_img)
    {
        //진행중인 애니메이션있으면 중지
        if(currentAnimator !=null)
        {
            currentAnimator.cancel();
        }
        ImageView expandedImageView;
        final View LinearLayout_view = (View) view.findViewById(R.id.back_ground);  //확장백그라운드
        final Rect startBounds = new Rect();//시작경계 - 축소그림에서 볼수있는 직사각형
        final Rect finalBounds = new Rect();//종료경계
        final Point globalOffset = new Point();
        thumbView.getGlobalVisibleRect(startBounds);//global좌표값을 가져온다?
        view.findViewById(R.id.container).getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y); //변위차를 이용하여 위치 설정
        finalBounds.offset(-globalOffset.x, -globalOffset.y);
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height() > (float) startBounds.width() / startBounds.height()) //종료xy값이 , 시작xy값보다 크면,
        {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        }

        else
        {
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

//        thumbView.setAlpha(0f); //버튼을 투명하게 만듬
//        thumbView.setEnabled(false);

        fac_view1.setAlpha(0f);
        fac_view1.setEnabled(false);
        fac_view2.setAlpha(0f);
        fac_view2.setEnabled(false);
        fac_view3.setAlpha(0f);
        fac_view3.setEnabled(false);
        fac_view4.setAlpha(0f);
        fac_view4.setEnabled(false);

        expeded_img.setVisibility(View.VISIBLE); //확장이미지 뵤여주기
        LinearLayout_view.setVisibility(View.VISIBLE); //백그라운드 보이기

        // Set the pivot point for SCALE_X and SCALE_Y transformations
        // to the top-left corner of the zoomed-in view (the default
        // is the center of the view).
        //확장이미지 시작점지정
        expeded_img.setPivotX(0f);
        expeded_img.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and
        // scale properties (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet(); //에니메이터셋 설정
        set.play(ObjectAnimator.ofFloat(expeded_img, View.X, startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(expeded_img, View.Y,startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(expeded_img, View.SCALE_X, startScale, 1f))
                .with(ObjectAnimator.ofFloat(expeded_img, View.SCALE_Y, startScale, 1f));
        set.setDuration(shortAnimationDuration); //동작시간설정
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                currentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                currentAnimator = null;
            }
        });
        set.start();
        currentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down
        // to the original bounds and show the thumbnail instead of
        // the expanded image.
        final float startScaleFinal = startScale;

         //expeded_img.setOnClickListener(new View.OnClickListener() { //확장된 이미지를 누르면
        back_button.setOnClickListener(new View.OnClickListener() { //확장된 이미지를 누르면
            @Override
            public void onClick(View view) {
                if (currentAnimator != null)
                {
                    currentAnimator.cancel();
                }

                // Animate the four positioning/sizing properties in parallel,
                // back to their original values.
                AnimatorSet set = new AnimatorSet();
                set.play(ObjectAnimator.ofFloat(expeded_img, View.X, startBounds.left))
                        .with(ObjectAnimator.ofFloat(expeded_img,View.Y,startBounds.top))
                        .with(ObjectAnimator.ofFloat(expeded_img,View.SCALE_X, startScaleFinal))
                        .with(ObjectAnimator.ofFloat(expeded_img,View.SCALE_Y, startScaleFinal));
                set.setDuration(shortAnimationDuration);
                set.setInterpolator(new DecelerateInterpolator());
                set.addListener(new AnimatorListenerAdapter()
                {
                    @Override
                    public void onAnimationEnd(Animator animation)
                    {
//                        thumbView.setAlpha(1f);
//                        thumbView.setEnabled(true);
                        fac_view1.setAlpha(1f);
                        fac_view1.setEnabled(true);
                        fac_view2.setAlpha(1f);
                        fac_view2.setEnabled(true);
                        fac_view3.setAlpha(1f);
                        fac_view3.setEnabled(true);
                        fac_view4.setAlpha(1f);
                        fac_view4.setEnabled(true);

                        expeded_img.setVisibility(View.GONE);
                        LinearLayout_view.setVisibility(View.GONE);

                        currentAnimator = null;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation)
                    {
//                        thumbView.setAlpha(1f);
//                        thumbView.setEnabled(true);
                        fac_view1.setAlpha(1f);
                        fac_view1.setEnabled(true);
                        fac_view2.setAlpha(1f);
                        fac_view2.setEnabled(true);
                        fac_view3.setAlpha(1f);
                        fac_view3.setEnabled(true);
                        fac_view4.setAlpha(1f);
                        fac_view4.setEnabled(true);

                        expeded_img.setVisibility(View.GONE);
                        LinearLayout_view.setVisibility(View.GONE);
                        currentAnimator = null;
                    }
                });
                set.start();
                currentAnimator = set;
            }
        });

    }
}

