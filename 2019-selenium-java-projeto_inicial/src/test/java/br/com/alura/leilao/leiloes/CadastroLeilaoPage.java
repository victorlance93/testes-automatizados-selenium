package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
    
    private WebDriver browser;
    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	

    public CadastroLeilaoPage(WebDriver browser) {
        this.browser = browser;
    }

    public void fechar() {
        this.browser.quit();
    }

	public LeiloesPage cadastrarLeilao(String nome, String valorInical, String dataAbertura) {
		this.browser.findElement(By.id("nome")).sendKeys(nome);
		this.browser.findElement(By.id("valorInicial")).sendKeys(valorInical);
		this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
		this.browser.findElement(By.id("button-submit")).submit();
		
		return new LeiloesPage(browser);
	}

	public boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
	}

	public boolean isPaginaDeValidacaoVisiveis() {
	    String pageSource = browser.getPageSource();
	    return pageSource.contains("minimo 3 caracteres")
	            && pageSource.contains("não deve estar em branco")
	            && pageSource.contains("deve ser um valor maior de 0.1")
	            && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
	}
}
