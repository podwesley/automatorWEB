package br.com.project.Framework.core;

import br.com.project.Framework.core.Constantes.TypeRun;
import br.com.project.Framework.utils.Diretorios;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {


    protected static Boolean closeDrive = Constantes.QUIT_DRIVER;

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {

        WebDriver driver = null;


        /***
         * Dispara os testes para localhost.
         */
        if (Constantes.TYPE_RUN == TypeRun.LOCAL) {


            if (Constantes.BROWSER == Constantes.Browsers.CHROME) {  //Trocar o Browser Aqui.

                ChromeOptions opcao = new ChromeOptions();
                opcao.addArguments(Constantes.CRHOME_OPTIONS);

                /***
                 * IMPORTANTE, CONFIGURAÇÕES E RECEBIMENTOS DE PARAMENTROS VIA MAVEN.
                 */

                String s = System.getProperty("ARGUMENTS_DRIVER_OPTIONS");

                if (s != null) {
                    String[] arr = s.split(",");

                    for (int i = 0; i < arr.length; i++) {

                        opcao.addArguments(arr[i]);

                    }
                    System.out.println("***** Iniciando o driver com as opções: " + s);
                }

                String encerraBrowser = System.getProperty("ARGUMENTS_ENCERRAR_BROWSER");

                if (encerraBrowser != null) {
                    System.out.println("PARAMETROS DO ENCERRAR BROWSER " + encerraBrowser);
                    closeDrive = Boolean.valueOf(encerraBrowser);
                    Constantes.QUIT_DRIVER = true;
                    System.out.println("VALOR DO CONST.QUIT_DRIVER: -> " + Constantes.QUIT_DRIVER);

                }

                //*******************************************************************************

                System.setProperty("webdriver.chrome.driver", new Diretorios().getPathArquivo("chromedriver.exe"));
                driver = new ChromeDriver(opcao);

            } else {

                FirefoxOptions opcao = new FirefoxOptions();
                System.setProperty("webdriver.gecko.driver", new Diretorios().getPathArquivo("geckodriver.exe"));
                driver = new FirefoxDriver(opcao);
            }

        }

        /***
         * Disparar os testes para um servidor GRID.
         */
        if (Constantes.TYPE_RUN == TypeRun.GRID) {
            DesiredCapabilities cap = null;
            switch (Constantes.BROWSER) {
                case FIREFOX:
                    cap = DesiredCapabilities.firefox();
                    break;
                case CHROME:
                    cap = DesiredCapabilities.chrome();
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:port/recursos"), cap);
            } catch (MalformedURLException e) {
                System.err.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
        }

        /***
         * Para executar os testes em um servidor remoto.
         */
        if (Constantes.TYPE_RUN == TypeRun.NUVEM) {
            DesiredCapabilities cap = null;
            switch (Constantes.BROWSER) {
                case FIREFOX:
                    cap = DesiredCapabilities.firefox();
                    break;
                case CHROME:
                    cap = DesiredCapabilities.chrome();
                    break;
                case IE:
                    cap = DesiredCapabilities.internetExplorer();
                    cap.setCapability("platform", "Windows 7");
                    cap.setCapability("version", "11.0");
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://endereconuvem.com"), cap);
            } catch (MalformedURLException e) {
                System.err.println("Falha na conexão com a nuvem");
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        driver.get(Constantes.URL);
        return driver;
    }

    public static void quitDriver(boolean b) {

        WebDriver driver = getDriver();

        if (b) {

            if (driver != null) {
                driver.quit();
                driver = null;
            }
            if (threadDriver != null) {
                threadDriver.remove();
            }
        }

    }


}
