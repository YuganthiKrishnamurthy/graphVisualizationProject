import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class file3 {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\kyuga\\Downloads\\DNR_Camping_Parks_Reservation_Data_2016.csv";
        BufferedReader br = null;
        String line = "";
        ArrayList<String> inputFile=new ArrayList<>(); int flag=0;
        ArrayList<String> inputFile3=new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            BufferedWriter bw3 = new BufferedWriter(new FileWriter("file3.csv"));
            while ((line = br.readLine()) != null) {
                if(flag==0)
                {
                    inputFile.add(line);flag=1;
                }
                if(flag==1){
                    String inputLine3[] = line.split(",");
                    if(inputLine3[8].trim().equals("Less than 20ft")) {
                        inputLine3[8]="LT20ft";
                    }
                    if(inputLine3[8].trim().equals("Less than 30ft")) {
                        inputLine3[8]="LT30ft";
                    }
                    if(inputLine3[8].trim().equals("Less than 40ft")) {
                        inputLine3[8]="LT40ft";
                    }
                    if(inputLine3[8].trim().equals("Single Tent")) {
                        inputLine3[8]="ST";
                    }
                    inputFile3.add(inputLine3[0]+","+inputLine3[1]+","+inputLine3[5]+","+inputLine3[7]+","+inputLine3[6]+","+inputLine3[8]);
                    for (String data : inputFile3) {
                        bw3.write(data);
                    }
                    bw3.newLine();
                    inputFile3.clear();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

