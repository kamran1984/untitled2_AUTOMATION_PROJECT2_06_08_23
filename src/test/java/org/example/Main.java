package org.example;//package org.example;
//
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        String expected1 = "Web Orders Login";
        String actual1 = driver.getTitle();
        Assert.assertEquals(actual1,expected1);


        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");


       Thread.sleep(500);
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

       driver.findElement(By.xpath("//a[@href=\"Process.aspx\"]")).click();

        int number = (int)(1+Math.random()*99);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(""+number);
        String attribute = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).getAttribute("value");

        if(number>10) {
            driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtDiscount']")).sendKeys("8");
        }
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();


        System.out.println(attribute);



        String expected2 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtTotal']")).getAttribute("value");
        String actual2 = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtTotal']")).getAttribute("value");
        Assert.assertEquals(actual2,expected2);

//        String alphabet = "QWERTYUIOPLKJHGFDSAZXCVBNM";
//        String str1 = "";
//        String str2 = "";
//        int num = (int)(4+Math.random()*10);
//        for (int i = 0; i < num; i++) {
//            int firstName =(int)(Math.random()*alphabet.length());
//            int lastName =(int)(Math.random()*alphabet.length());
//
//            str1+= alphabet.charAt(firstName);
//            str2+= alphabet.charAt(lastName);
//        }






                String[] firstNames = {
                        "John", "Jane", "Michael", "Emily", "William", "Olivia", "James", "Emma", "Alexander", "Sophia"
                };

                String[] lastNames = {
                        "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"
                };
        String[] streets = {
               " Main Street.","2nd Street."," 3rd Street.","4th Street.","5th Street.","6th Street.","7th Street.","1st Street."
        };


        String[] citys ={"New York"," Los Angeles"," Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas",  "San Jose"};

        String[] usStates = {
                "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware",
                "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky",
                "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi",
                "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
                "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
                "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
        };

        String[] zipcodes = { "64152","66741","47158","66447","64118"};

        String[] cardTypes ={"//input[@id='ctl00_MainContent_fmwOrder_cardList_0']","//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"
                ,"//input[@id='ctl00_MainContent_fmwOrder_cardList_2']"};


                Random random = new Random();


                int firstNameIndex = random.nextInt(firstNames.length);
                String firstName = firstNames[firstNameIndex];


                int lastNameIndex = random.nextInt(lastNames.length);
                String lastName = lastNames[lastNameIndex];

                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);



        String firstAndLastName =firstName+"      "+lastName;
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(firstAndLastName);



        int streetIndex = random.nextInt(streets.length);
        String street = streets[streetIndex];
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']")).sendKeys(street);

        int cityIndex = random.nextInt(citys.length);
        String city = citys[cityIndex];
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(city);

        int stateIndex = random.nextInt(usStates.length);
        String state = usStates[stateIndex];
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(state);


        int zipcodeIndex = random.nextInt(zipcodes.length);
        String zipcode = zipcodes[zipcodeIndex];
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(zipcode);


        int cardTypeIndex = random.nextInt(cardTypes.length);
        String cardType = cardTypes[cardTypeIndex];
        driver.findElement(By.xpath(cardType)).click();

        if(cardType.equals("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")){
            driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys("4"+(long)(Math.random()*10000000000000000l));
        }else if(cardType.equals("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']")){
            driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys("5"+(long)(Math.random()*10000000000000000l));
        }else {
            driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys("3"+(long)(Math.random()*1000000000000000l));
        }



        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys("06/2023");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();


//        String expected3 = "New order has been successfully added";
//        String actual3 = driver.getTitle();
//        Assert.assertEquals(actual3,expected3);



    }


}
