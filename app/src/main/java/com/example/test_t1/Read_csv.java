package com.example.test_t1;

import java.io.*;
import java.util.*;

public class Read_csv
{
    public Read_csv()
    {
//        Read_csv csvReader = new Read_csv();
//        csvReader.readCSV();
    }

    public List<List<String>> readCSV(String path) {
        List<List<String>> csvList = new ArrayList<List<String>>();
        File csv = new File(path);
        System.out.println("csv파일리스트임"+csv);
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                List<String> aLine = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("오류 남"+ e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close(); // 사용 후 BufferedReader를 닫아준다.
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return csvList;
    }
}