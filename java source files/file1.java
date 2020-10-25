import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class file1 {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\kyuga\\Downloads\\DNR_Camping_Parks_Reservation_Data_2016.csv";
        BufferedReader br = null;
        String line = "";
        ArrayList<String> inputFile=new ArrayList<>(); int flag=0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if(flag==0){
                    inputFile.add(line);
                    flag=1;
                }
                if(flag==1){
                    String inputLine[]=line.split(",");
                    if(inputLine[2].trim().equals("CANADA")) {
                        inputFile.add(line);
                    }
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

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("file1.csv"));
            for (String data : inputFile) {
                bw.write(data);
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

