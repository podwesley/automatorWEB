package br.com.project.Framework.core;

import br.com.project.Framework.utils.Log;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Acoes {

    private WebDriver driverFactory = DriverFactory.getDriver();
    protected WebDriver driver = driverFactory;

    /***
     * RECEBE UM VALOR ESPECIFICO E DIGITA EM UM CAMPO.
     * @param locator
     * @param value
     */
    protected void digitaValor(By locator, String value) {

        aguardarElementoNaTela(locator);
        Log.info("Digitando valor: " + value);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator));
        actions.click();
        actions.sendKeys(value);
        actions.build().perform();
        Allure.step("Digitando: " + value + " campo: " + locator );
    }

    protected void clicar(By locator){
        aguardarElementoNaTela(locator);
        driver.findElement(locator).click();
        Allure.step("Clicando em: " + locator);
    }

    /***
     * ESPERA O ELEMENTO APARECER NA TELA PARA EFETUAR ALGUMA AÇÃO.
     * @param locator
     * @return
     */
    protected boolean aguardarElementoNaTela(By locator) {

        Log.info("Aguardando por elemento na tela: " + locator);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.isDisplayed() || element.isEnabled();

    }

    /***
     * AGUARDA O ELEMENTO FICAR INVISÍVEL PARA EFETUAR ALGUMA AÇÃO.
     * @param locator
     */
    protected void aguardarElementoSumir(By locator) {
        Log.info("Aguardando elemento sumir: " + locator);
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
    }

}
