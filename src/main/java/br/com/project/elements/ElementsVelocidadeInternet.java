package br.com.project.elements;

import br.com.project.Framework.core.Acoes;
import org.openqa.selenium.By;

public class ElementsVelocidadeInternet extends Acoes {

    public By campoPesquisaGoogle = By.name("q");
    public By botaClicar = By.name("btnK");
    public By texto = By.xpath("//span[text()='testes de velocidade internet']");
    public By botaoTestarVelocidade = By.xpath("//div[text()='EXECUTAR TESTE DE VELOCIDADE']");

}
