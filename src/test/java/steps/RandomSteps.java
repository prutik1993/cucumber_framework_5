package steps;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.Driver;
import utils.Waiter;

import java.util.Date;

public class RandomSteps {

    @Test
    public void getRandomData(){
        Faker faker = new Faker();

        Driver.getDriver().get("https://www.google.com/");

        Driver.getDriver().findElement(By.name("q")).sendKeys(faker.funnyName().name() + Keys.ENTER);
        Waiter.pause(3);
        Driver.quitDriver();


    }
}
