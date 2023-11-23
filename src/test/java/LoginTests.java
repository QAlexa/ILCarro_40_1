import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "apple@gmail.com", password = "Ap654322$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().buttonYalla();
        app.getUser().popup();
      //  app.getUser().logout();
        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.=' Logout ']")));
        app.getUser().logout();


    }
}
