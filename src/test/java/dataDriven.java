import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class dataDriven {
    public static void main(String[] args) throws IOException {

        //file input stream agument - this is what XSSFWorkbook accepts
        //FileInputStream is a java class which has a power to read any file
        //we are creating fis object which can reas our file
        FileInputStream fis = new FileInputStream("C:\\Users\\IzabelaMilisiewicz\\Downloads\\DemoData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);  //we are creating object of class XSSFWorkbook that we can use methods from this class
        //now our workbook can go inside our excel file

        //now we have to go read particular sheet
        int sheets = workbook.getNumberOfSheets();
        for(int i=0;i<sheets;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("testdata")){
            XSSFSheet sheet = workbook.getSheetAt(i);
            //it will scan sheets and get sheet which we are looking for

                //identify testcases column by scanning first row, you cannot hardcode index, because excel file may be changed
                //once column is identified scan entire testcases column to identify Purchase test case
                //after you have Purchase row pull all data from the row
                //we will use poi logic to implement those 3 scenarios

                Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
                //now rows object has ability to scan all rows in our excel
                Row firstrow = rows.next(); //here we have all cells from first row
                Iterator<Cell> ce = firstrow.cellIterator(); //row is collection of cells
                int k = 0; //k=0 is the forst column
                int column = 0;
                while(ce.hasNext()){ //checking if next cell is present
                    Cell value = ce.next();
                    if(value.getStringCellValue().equalsIgnoreCase("testcases")){
                        //desired column
                        column = k; //column is actual column number for particular iteration
                    }
                    k++;
                }
                System.out.println(column);

                //once column is identified scan entire testcases column to identify Purchase test case

            }
        }
    }
}
