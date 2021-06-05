import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

public class AppTest {


    @Test
    public void testHappyPath() throws Exception {
        AppiumDriver<MobileElement> driver = new MyDriver().getDriver();
        AppActions appActions = new AppActions(driver);
        appActions.waitTillAppStarts();
        appActions.tap(536, 733);
        appActions.enterText("3188860-7", 24);
        appActions.clickOnText("GUARDAR");
        appActions.clickOnText("ACEPTAR");
        appActions.clickOnText("GUARDAR");
        appActions.clickOnText("GUARDAR");
        appActions.clickOnText("ALLOW");
        appActions.clickOnElementBeforeText("Calendario Tributario");
        appActions.logEvent();
    }


}
