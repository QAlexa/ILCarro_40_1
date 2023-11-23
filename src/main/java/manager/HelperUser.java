package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        wd.findElement(By.xpath("//a[.=' Log in ']")).click();
    }
    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);
    }

    public void buttonYalla(){
        click(By.xpath("//button[.='Y’alla!']"));
    }
    public void popup() {click(By.xpath("//button[.='Ok']"));}
    public void logout() {click(By.xpath("//a[.=' Logout ']"));}

    public boolean isLogged(){

        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }
}

