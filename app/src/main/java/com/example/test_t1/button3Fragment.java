package com.example.test_t1;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test_t1.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class button3Fragment extends Fragment {
    private View view;
    private List list_csv;

    LineChart chart;
    Thread data_run;
    ArrayList<issue_data> issueDataList;


    int i=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        System.out.println("3번 프래그먼트실행");




        view = inflater.inflate(R.layout.fragment_btn3,container,false);


        //차트코드
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
}
