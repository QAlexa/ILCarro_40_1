import manager.TestNgListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestNgListener.class)

public class LoginTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (app.getUser().isLogged()){
            app.getUser().logout();
        }

        }

    @Test
    public void loginPositive() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("apple@gmail.com", "Ap654322$");
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedSuccess());


//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        String email = "apple@gmail.com", password = "Ap654322$";
        //     app.getUser().openLoginForm();
        //     app.getUser().fillLoginForm(email, password);
//        app.getUser().buttonYalla();
//        app.getUser().popup();
//      //  app.getUser().logout();
//        app.getUser().pause(5000);
//
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.=' Logout ']")));
//        app.getUser().logout();

    }

    @Test
    public void loginPositiveUser() {

        User user = new User()
                .withEmail("apple@gmail.com")
                .withPassword("Ap654322$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedSuccess());


    }

    @Test
    public void loginPositiveUserData() {
        User user = new User()
                .withEmail("apple@gmail.com")
                .withPassword("Ap654322$");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }



    @AfterMethod
    public void postcondition() {
        app.getUser().popup();


    }

}