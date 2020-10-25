import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class file2 {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\kyuga\\IdeaProjects\\dataAssignment\\file1.csv";
        BufferedReader br = null;
        String line = "";
        ArrayList<String> inputFile2 = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("file2.csv"));
            while ((line = br.readLine()) != null) {
                String inputLine2[] = line.split(",");
                inputFile2.add(inputLine2[0]+","+inputLine2[1]+","+inputLine2[5]+","+inputLine2[7]+","+inputLine2[6]+","+inputLine2[8]);
                for (String data : inputFile2) {
                    bw2.write(data); }
                        bw2.newLine();
                        inputFile2.clear();
                                }
                                  }
        catch (FileNotFoundException e) {
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







