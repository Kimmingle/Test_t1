package com.example.test_t1;

import android.os.Parcel;
import android.os.Parcelable;

public class issue_data implements Parcelable {
    private int issue_img; //이슈이미지
    private String issue; //이슈
    private String fac_line; //공장라인
    private String moter_name; //모터이름

    private String day_time; //이슈시기
    private String moter_state; //이상진단 0~4
    private String solution; //해결방안

    private String text1; //첫째줄
    private String text2; //둘째줄
    private String text3; //셋째줄

    public issue_data(int issue_img,
                      String issue,
                      String fac_line,
                      String moter_name,
                      String day_time,
                      String moter_state,
                      String solution){

        this.issue_img = issue_img;
        this.issue = issue;
        this.fac_line = fac_line;
        this.moter_name = moter_name;
        this.day_time = day_time;
        this.moter_state = moter_state;
        this.solution = solution;

        //int로 받은값들 배열내 들어있는 string값들꺼내는 인덱스로 사용
        //밭은 데이터들 3개 줄에 합치기
    }

    protected issue_data(Parcel in) {
        issue_img = in.readInt();
        issue = in.readString();
        fac_line = in.readString();
        moter_name = in.readString();
        day_time = in.readString();
        moter_state = in.readString();
        solution = in.readString();
        text1 = in.readString();
        text2 = in.readString();
        text3 = in.readString();
    }

    public static final Creator<issue_data> CREATOR = new Creator<issue_data>() {


        @Override
        public issue_data createFromParcel(Parcel in) {
            return new issue_data(in);
        }

        @Override
        public issue_data[] newArray(int size) {
            return new issue_data[size];
        }
    };

    public int getIssue(){
        return this.issue_img;
    }

    public String getTextview1()
    {
        String result = issue+ " "+ fac_line+ " "+ moter_name;
        return result;
    }

    public String getTextview3()
    {
        String result = moter_state+" "+ solution;
        return result;
    }

    public String getMoter_name(){
        return this.moter_name;
    }

    public String getDay_time(){
        return this.day_time;
    }

    public String getFac_line(){return this.fac_line;}
    public String getSolution(){
        return this.solution;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
         parcel.writeInt(issue_img);
         parcel.writeString(issue);
         parcel.writeString(fac_line);
         parcel.writeString(moter_name);
         parcel.writeString(day_time);
         parcel.writeString(moter_state);
         parcel.writeString(solution);

         parcel.writeString(text1);
         parcel.writeString(text2);
         parcel.writeString(text3);
    }
}
