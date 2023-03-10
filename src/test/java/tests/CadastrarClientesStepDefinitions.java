package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastrarClientesStepDefinitions {

	WebDriver driver;
	
	@Dado("Acessar a página de cadastro de clientes")
	public void passo1(){
		
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testesoftware1-001-site1.etempurl.com/exercicios/tarefa04");
	}
	
	@E("Informar o nome do cliente")
	public void passo2(){
		
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Ana Paula");
	}
	
	@E("Informar o telefone do cliente")
	public void passo3(){
		
		driver.findElement(By.xpath("//*[@id=\"Telefone\"]")).sendKeys("(21)99999-0000");
	}
	
	@E("Informar a data de nascimento do cliente")
	public void passo4(){
		
		driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]")).sendKeys("10/04/1985");
	}
	
	@E("Selecionar o plano do cliente {string}")
	public void passo5(String plano){
		
		new Select(driver.findElement(By.xpath("//*[@id=\"TipoPlano\"]"))).selectByVisibleText(plano);
	}
	
	@E("Informar as observações")
	public void passo6(){
		
		driver.findElement(By.xpath("//*[@id=\"Observacoes\"]")).sendKeys("Cliente para teste");
	}
	
	@Quando("Solicitar a realização do cadastro do cliente")
	public void passo7(){
		
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}
	
	@Então("Sistema informa que o cliente foi cadastrado com sucesso")
	public void passo8(){
		
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem,"Cliente cadastrado com sucesso.");
		
        try {
        
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Cadastrar Clientes.png"));	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		driver.close();
	}
}
