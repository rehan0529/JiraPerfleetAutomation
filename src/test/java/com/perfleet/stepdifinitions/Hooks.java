package com.perfleet.stepdifinitions;


import com.perfleet.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){

        System.out.println("\tthis is coming from BEFORE");
    }

    @After    //day22 at 1.46REC
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tconnecting to DataBase-------");
    }

    @After("@db")
    public void closedb(){

        System.out.println("\tDisconnecting from DaraBase-------");
    }
}
