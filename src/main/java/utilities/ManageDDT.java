package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {


    /* ---------------------------------------------------
        Method Name: getDataObject
        Method Description: This method gets the data from the getDataFromCSV(ddtFilePath)
        method and pass it to the tests that are using DDT.
        Method Parameters: void
        Method Return: Object[][]
        --------------------------------------------------- */
    @DataProvider(name = "data-provider")
    public static Object[][] getDataObject(){
        return getDataFromCSV(ddtFilePath);
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

    /* ---------------------------------------------------
        Method Name: getDataFromCSV
        Method Description: This method fetches the data from a CSV file
        and prepares it for DDT testing.
        Method Parameters: String csvFile
        Method Return: Object[][]
        --------------------------------------------------- */
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
