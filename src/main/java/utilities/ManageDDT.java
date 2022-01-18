package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {


    @DataProvider(name = "data-provider-items")
    public static Object[][] getDataObject(){
        return getDataFromCSV(getData("DDTFile"));
    }

    public static List<String> readCSV(String csvFile) {
        List<String > lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        } catch (IOException e){
            System.out.println(e);
        }
        return lines;
    }

    public static Object[][] getDataFromCSV(String csvFile) {
        List<String> stringsLines = readCSV(csvFile);
        int rowSize = stringsLines.size();
        int columSize = stringsLines.get(0).split(",").length;
        Object[][] objects = new Object[columSize][rowSize];
        for (int i=0; i< rowSize; i++) {
            String[] columArr = stringsLines.get(i).split(",");
            for (int j = 0; j < columSize; j++) {
                objects[j][i] = columArr[j];
            }
        }
        return objects;
    }

}
