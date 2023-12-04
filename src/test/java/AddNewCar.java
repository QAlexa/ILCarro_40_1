import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase{
    @BeforeMethod
    public void precondition(){

        if(app.getUser().isLogged() == false)
            app.getUser().login(
                new User().withEmail("apple@gmail.com").withPassword("Ap654322$"));

    }
    @Test
    public void addNewCarPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Car car = Car.builder()
                .location("Tel Aviv")
                .manufacture("KIA")
                .model("Sportage")
                .year("2022")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .carRegNumber("100-202-"+i)
                .price("150")
                .about("")
                .build(); //построение обьекта с помощью ломбок
    app.getCar().openCarForm();
    app.getCar().fillCarForm(car);
    app.getUser().submitLogin();

    }
}
