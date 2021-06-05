import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class AppActions {
    private AppiumDriver<MobileElement> driver;

    public AppActions(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void waitTillAppStarts() throws Exception {
        int counter = 0;
        while (true) {
            counter++;
            Thread.sleep(2000);

            if (counter >= 7) {
                throw new Exception("App did not start after maximum time of 14 seconds");
            }
            try {
                swipeLeft();
                if (driver.findElements(By.xpath("//*")).get(5).getText().equals("SAT GT")) {
                    break;
                }
            } catch (Exception e) {
            }
        }
    }

    public void swipeLeft() {
        new TouchAction(driver)
                .press(PointOption.point((int) (driver.manage().window().getSize().getWidth() * 0.80), driver.manage().window().getSize().getHeight() / 2))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
                .moveTo(PointOption.point((int) (driver.manage().window().getSize().getWidth() * 0.20), driver.manage().window().getSize().getHeight() / 2))
                .release()
                .perform();
    }

    public void tap(int x, int y) {
        new TouchAction(driver)
                .press(PointOption.point(x, y))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(1000)))
                .release()
                .perform();
    }

    public void logEvent() {
        while (true) {
            try {
                List<MobileElement> elements = driver.findElements(By.xpath("//*"));
                String event = elements.get(27).getText() + " " + elements.get(28).getText() + "\n" + elements.get(32).getText();
                System.out.println("Evento:\n"+event);
                break;
            } catch (Exception e) {

            }
        }
    }


    public void clickOnText(String text) {
        boolean loop = true;
        while (loop) {
            try {
                Thread.sleep(500);
                List<MobileElement> elements = driver.findElements(By.xpath("//*"));
                for (MobileElement element : elements) {
                    if (element.getText().equals(text)) {
                        element.click();
                        loop = false;
                        break;
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public void clickOnElementBeforeText(String text) {
        boolean loop = true;
        while (loop) {
            try {
                Thread.sleep(500);
                List<MobileElement> elements = driver.findElements(By.xpath("//*"));
                for (int i = 0; i < elements.size(); i++) {
                    if (elements.get(i).getText().equals(text)) {
                        elements.get(i - 1).click();
                        loop = false;
                        break;
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public void enterText(String text, int position) throws InterruptedException {
        while (true) {
            try {
                driver.findElements(By.xpath("//*")).get(position).sendKeys("3188860-7");
                break;
            } catch (Exception e) {
                Thread.sleep(500);
            }
        }
    }
}
