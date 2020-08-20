package br.com.nameproject.configuration.base;

import org.junit.Assert;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.nameproject.configuration.models.ConfiguracaoAmbiente;
import br.com.nameproject.configuration.suporte.EnumNavegador;
import br.com.nameproject.configuration.suporte.Utilitario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverBase extends AcaoBase {

	private WebDriver driver;

	public DriverBase(WebDriver driver) {
		this.driver = driver;
	}

	public DriverBase(ConfiguracaoAmbiente configuracao) {
		instanciarDriverManual(configuracao);
	}

	public void navegar(String url) {
		this.driver.navigate().to(url);
	}

	public WebDriver driver() {
		return this.driver;
	}

	public void fecharNavegador() {
		this.driver.quit();
	}

	/**
	 * Método para instanciar o driver automaticamente com o WebDriverManager
	 */
	public void instanciarDriverAutomatico(ConfiguracaoAmbiente configuracao) {
		if (configuracao.getNavegador().equals(EnumNavegador.FIREFOX)) {
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
			this.driver.manage().window().maximize();
		} else if (configuracao.getNavegador().equals(EnumNavegador.CHROME)) {
			for (int versionChrome = 84; versionChrome >= 72; versionChrome--) {
				try {
					WebDriverManager.chromedriver().version(Integer.toString(versionChrome)).setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					this.driver = new ChromeDriver(options);
					return;
				} catch (SessionNotCreatedException e) {
					this.driver.quit();
					if (versionChrome == 72)
						e.printStackTrace();
				}
			}
		} else {
			Assert.fail("Navegador informado não faz parte da configuração");
		}

	}

	/**
	 * Método para instanciar o driver manualmente
	 */
	public void instanciarDriverManual(ConfiguracaoAmbiente configuracao) {
		if (configuracao.getNavegador().equals(EnumNavegador.FIREFOX)) {
			System.setProperty("webdriver.gecko.driver", Utilitario.CaminhoProjeto + "\\drivers\\geckodriver.exe");
			this.driver = new FirefoxDriver();
			this.driver.manage().window().maximize();
		} else if (configuracao.getNavegador().equals(EnumNavegador.CHROME)) {
			for (int versionChrome = 84; versionChrome >= 72; versionChrome--) {
				try {
					System.setProperty("webdriver.chrome.driver", Utilitario.CaminhoProjeto + "\\drivers\\chromedriver_" + versionChrome + ".exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					this.driver = new ChromeDriver(options);
					return;
				} catch (SessionNotCreatedException e) {
					this.driver.quit();
					if (versionChrome == 72)
						e.printStackTrace();
				}
			}
		} else {
			Assert.fail("Navegador informado não faz parte da configuração");
		}
	}

}
