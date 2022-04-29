package testng.miit;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MiitDataExample {

    static int MAX_PRIORITY = 10;
    
      HashMap<String,String> dataMap = new HashMap<String,String>(); 
      @DataProvider(name = "data-provider")
        public Object[][] dataProviderMethod() {
            return new Object[][] { { "username","pinkesh" }, {"username", "mehul"}};
        }
     
          //@Parameters({"a","b"})  
      //dependsOnMethods = {"test"},
        @Test(dataProvider = "data-provider")
        public void testMethod( String data, Object data2) {
            System.out.println("Data is: " + data + ": data 2"+ data2);
        }
    
    @BeforeTest
    public void load_data() {
        try(FileInputStream file = new FileInputStream(new File("C:\\java_Trainning\\Student_Infromation.xlsx"))) {


            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // Check the cell type and format accordingly
                    String value = cell.getStringCellValue();
                    System.out.println("Value is ::"+value);
                    dataMap.put(value,value);
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2() {
        System.out.println("Test 1");
        dataMap.get("key");
    }
    
    @Test
    public void test3() {
        System.out.println("Test 2");
        
    }

    /*
     * @Test public void test1() { System.out.println("Test:::"); }
     * 
     * @Test public void test2() { System.out.println("Test:::"); }
     */

}