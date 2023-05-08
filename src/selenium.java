import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selenium {
    public static void main(String[] args) {
        // Atur path driver Chrome
        WebDriverManager.chromedriver().setup();

        // Buka browser Chrome
        WebDriver driver = new ChromeDriver();

        // Buka website Tokopedia
        driver.get("https://www.tokopedia.com/");

        // Cari dan masukkan query pada kolom pencarian
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='css-3017qm exxxdg63']"));
        searchBox.sendKeys("iPhone 13");
        searchBox.sendKeys(Keys.ENTER);

        // Tunggu hingga halaman selesai dimuat dan cari tombol filter
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Tunggu hingga panel filter selesai dimuat dan cari filter harga
        WebElement priceFilter = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Harga Minimum']")));

        // Bersihkan nilai yang ada dan masukkan harga minimum
        priceFilter.clear();
        priceFilter.sendKeys("15000000");
        priceFilter.sendKeys(Keys.ENTER);

        // Cari filter harga maksimum dan masukkan harga maksimum
        WebElement maxPriceFilter = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Harga Maksimum']")));
        maxPriceFilter.clear();
        maxPriceFilter.sendKeys("20000000");
        maxPriceFilter.sendKeys(Keys.ENTER);

        // Cari tombol terapkan filter dan klik pada tombol tersebut
        WebElement applyFilterButton = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Laman 2']")));
        applyFilterButton.click();

        // Cari produk pertama dan klik pada produk tersebut
        WebElement firstProduct = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//div[@class='css-1f2quy8'])")));
        firstProduct.click();

        // Cari tombol tambahkan ke keranjang dan klik pada tombol tersebut
        WebElement addToCartButton = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[@class='css-7k78ah-unf-btn eg8apji0']")));
        addToCartButton.click();

        // Cari kolom nomor telepon dan masukkan nomor telepon
        WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='email-phone-input']")));
        number.sendKeys("080391695418");
        number.sendKeys(Keys.ENTER);

        
    }
}
