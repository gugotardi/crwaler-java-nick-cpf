import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Crawlernickcpf {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		/*O webdriver gecko é obrigatório no seleniun para evitar o uso da ferramenta em ataques hackers*/
		System.setProperty("webdriver.gecko.driver","c:/your/path/to/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		/*Criando o arquivo txt*/
		File f = new File("C:\\Temp\\arquivo.txt");
		f.createNewFile();
		FileWriter arq = new FileWriter("C:\\Temp\\arquivo.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
		
		/*Acessa p site da 4 devs para gerar os Niks*/
		driver.get("https://www.4devs.com.br/gerador_de_nicks");
		
		/*Processo de escolha dos campos método, quantidade de nicks e quantos caracteres cada nick"*/
		WebElement campoMetodo = driver.findElement(By.id("method"));
		Thread.sleep(1000);/*Usei alguns thread sleep para cadenciar a execução do processo e evitar que sistema gere informações erradas*/
		campoMetodo.sendKeys("Aleatório");
		Thread.sleep(1000);
		WebElement campoGeradorNick = driver.findElement(By.id("quantity"));
		campoGeradorNick.clear();
		Thread.sleep(1000);
		campoGeradorNick.sendKeys("50");
		Thread.sleep(1000);
		WebElement campoLimite = driver.findElement(By.id("limit"));
		Thread.sleep(1000);
		campoLimite.sendKeys("8");
		Thread.sleep(1000);
		
		/*Processo do click do botão para gerar o nick"*/
		WebElement botaoGerar = driver.findElement(By.id("bt_gerar_nick"));
		Thread.sleep(1000);
		botaoGerar.click();
		Thread.sleep(1000);
		
		/*Processo de salvar os nick's em list e depois usando um for, salva os dados no array nickname*/
		String[] nickName = new String[50];
		int y=0;
		List<WebElement> elements = driver.findElements(By.cssSelector("span[class='generated-nick']"));
		for(WebElement ele:elements) {
			nickName[y]=ele.getText();
			y=y+1;
		}
        Thread.sleep(1000);
        
        /*Acessa p site da 4 devs para gerar os Cpf's*/
		driver.get("https://www.4devs.com.br/gerador_de_cpf");
		Thread.sleep(1000);
		
		/*Processo de gerar os cpf's: Usou-se um for para que o botão seja clicado 50 vezes pelo Crawler e os resultados foram salvos em um array cpf*/
		String[] cpf = new String[50];
		for(int i = 0; i<50; i++) {
			WebElement cliqueBotao = driver.findElement(By.id("bt_gerar_cpf"));
			Thread.sleep(1000);
			cliqueBotao.click();
			Thread.sleep(1000);
			WebElement campoCpf = driver.findElement(By.id("texto_cpf"));
			Thread.sleep(1000);
		    cpf[i] = campoCpf.getText(); 
		}
		
		for(int i = 0; i<50; i++) {
			gravarArq.println(nickName[i]+"; "+cpf[i]);
		}
		
		arq.close();
		System.out.println("Arquivo txt gerado com sucesso");
		/*Fim da execução do programa*/
		
		
	
		
		
	}
	
	

}

