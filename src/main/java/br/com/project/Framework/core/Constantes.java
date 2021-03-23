package br.com.project.Framework.core;

public class Constantes {


    // mvn clean site -DARGUMENTS_DRIVER_OPTIONS="--headless" -DARGUMENTS_ENCERRAR_BROWSER=true  Anonimo --incognito

    //CONFIGURAÇÕES
    public static final String CRHOME_OPTIONS = "--no-sandbox";

    // AMBIENTES
    public static final String URL = "https://www.google.com.br/";

    // USUARIOS
    public static final String USUARIOS = "C14545";


    public static final String PASSWORD = "";
    // PASSWORDS

    // CREDENCIAIS DE ACESSO.
    public static final String URL_MAIL = "mailnesia.com";
    public static Boolean QUIT_DRIVER = false;
    public static Browsers BROWSER = Browsers.CHROME;

    public static TypeRun TYPE_RUN = TypeRun.LOCAL;

    public enum Browsers {
        CHROME,
        FIREFOX,
        IE
    }

    public enum TypeRun {
        LOCAL,
        GRID,
        NUVEM
    }

}
