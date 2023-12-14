import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }
        @Test
        public void registrationpositive () {

            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            User user = new User()
                    .withName("Snowball")
                    .withLastname("John")
                    .withEmail("John" +i +"@gmail.com")
                    .withPassword("$Asdf1234");

            app.getUser().openRegistrationForm();
            logger.info("openRegistrationForm invoked");
            app.getUser().fillRegistrationForm(user);
            logger.info("fillRegistrationForm invoked");
            app.getUser().submitLogin();
            logger.info("submitLogin invoked");
            logger.info("registrationpositive starts with credentials: "+"login: " +user.getEmail() + "  password: " + user.getPassword());
            Assert.assertTrue(app.getUser().isLoggedSuccess());

        }

        @Test
        public void registrationNegativeUserAlreadyExist(){
        User user = new User()
                .withName("Snowball")
                .withLastname("John")
                .withEmail("John@gmail.com")
                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoggedNotSuccess());

        }

    @Test
    public void registrationNegativeWrongPassword () {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Snowball")
                .withLastname("John")
                .withEmail("John" +i +"@gmail.com")
                .withPassword("Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        //Assert.assertTrue(app.getUser().isLoggedSuccess());

    }

        @AfterMethod
        public void postcondition () {
            app.getUser().popup();


        }

    }

