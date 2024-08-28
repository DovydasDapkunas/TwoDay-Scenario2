import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class twoday2 {
    public static void main(String[] args) {
        // Setup WebDriver

        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Step 1: Open the online shop
            driver.get("https://magento.softwaretestingboard.com/");

            // Step 2: Navigate to Women Pants Section
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement womenMenu = wait.until(
                    ExpectedConditions.elementToBeClickable(By.linkText("Women"))
            );
            womenMenu.click();

            WebElement pantsSection = wait.until(
                    ExpectedConditions.elementToBeClickable(By.linkText("Pants"))
            );
            pantsSection.click();

            // Step 3: Sort by Price
            WebElement sortBy = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("sorter"))
            );
            sortBy.click();
            WebElement sortByPrice = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//option[@value='price']"))
            );
            sortByPrice.click();

            // Step 4: Add Karmen Yoga Pant to the cart
            WebElement karmenYogaPant = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Karmen Yoga Pant')]"))
            );
            karmenYogaPant.click();

            WebElement sizeOptionKarmen = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@option-label='28']"))
            );
            sizeOptionKarmen.click();

            WebElement colorOptionKarmen = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@option-label='Black']"))
            );
            colorOptionKarmen.click();

            WebElement addToCartButtonKarmen = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button"))
            );
            addToCartButtonKarmen.click();

            // Step 5: Navigate back to Pants section to add Sylvia Capri
            driver.navigate().back();
            driver.navigate().back(); // Ensure you return to the pants list page

            WebElement sylviaCapri = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Sylvia Capri')]"))
            );
            sylviaCapri.click();

            WebElement sizeOptionSylvia = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@option-label='28']"))
            );
            sizeOptionSylvia.click();

            WebElement colorOptionSylvia = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//div[@option-label='Blue']"))
            );
            colorOptionSylvia.click();

            WebElement addToCartButtonSylvia = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button"))
            );
            addToCartButtonSylvia.click();

            // Step 6: Open the cart
            WebElement cartIcon = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.showcart"))
            );
            cartIcon.click();

            // Step 7: Remove Sylvia Capri from the cart
            WebElement removeSylvia = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Remove item'][@data-cart-item]"))
            );
            removeSylvia.click();

            // Step 8: Confirm the removal by clicking "OK"
            WebElement confirmRemove = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='action-primary action-accept']"))
            );
            confirmRemove.click();

            // Step 9: Click on "View and Edit Cart"
            WebElement viewAndEditCartButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.viewcart"))
            );
            viewAndEditCartButton.click();

            // Step 10: Add Go-Get'r Pushup Grips to the cart
            WebElement addToCartPushupGrips = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Add to Cart' and ancestor::div[contains(@class,'product-item')]]"))
            );
            addToCartPushupGrips.click();

            // Step 11: Proceed to Checkout
            WebElement proceedToCheckoutButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.primary.checkout"))
            );
            proceedToCheckoutButton.click();

            // Step 12: Fill out the shipping information
            WebElement emailField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("customer-email"))
            );
            emailField.sendKeys("dovydapkunas@gmail.com");

            WebElement firstNameField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("firstname"))
            );
            firstNameField.sendKeys("Dovydas");

            WebElement lastNameField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("lastname"))
            );
            lastNameField.sendKeys("Dapkunas");

            WebElement streetAddressField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("street[0]"))
            );
            streetAddressField.sendKeys("Giedraiciu 3");

            WebElement cityField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("city"))
            );
            cityField.sendKeys("Test City");

            Select stateDropdown = new Select(wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("region_id"))
            ));
            stateDropdown.selectByVisibleText("California");

            WebElement zipField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("postcode"))
            );
            zipField.sendKeys("90001");

            Select countryDropdown = new Select(wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("country_id")))
            );
            countryDropdown.selectByVisibleText("United States");

            WebElement phoneField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.name("telephone"))
            );
            phoneField.sendKeys("1234567890");

            // Step 13: Select Shipping Method
            WebElement shippingMethod = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='tablerate_bestway']"))
            );
            shippingMethod.click();

            // Step 14: Click "Next"
            WebElement nextButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button.button.action.continue.primary"))
            );
            nextButton.click();

            // Step 15: Wait and scroll to "Place Order", then click
            WebElement placeOrderButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button.action.primary.checkout"))
            );

            // Scroll into view and attempt to click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);

            // Retry click mechanism
            int attempts = 0;
            while (attempts < 3) {
                try {
                    placeOrderButton.click();
                    break;
                } catch (Exception e) {
                    attempts++;
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
            }

            System.out.println("Order placed successfully.");


        } finally {
            // Close the browser
            driver.quit();
        }
    }
}