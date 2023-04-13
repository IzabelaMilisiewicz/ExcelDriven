import java.io.IOException;
import java.util.ArrayList;

public class testSample {

    public static void main(String[] args) throws IOException {

        dataDriven d = new dataDriven();  //creating object to access any method in that class
        ArrayList data = d.getData("Add profile");

        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));

        //driver.findElement(by.xpath("example xpath")).sendKeys(data.get(1));
    }
}
