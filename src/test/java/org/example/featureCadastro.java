package org.example;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.AppiumDriver;
import org.example.PageObjects.CadastroPageObject;
import org.example.PageObjects.LoginPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class featureCadastro {

    private LoginPageObject telaLogin;

    @Test
    public void nao_consigo_cadastrar_senhas_diferentes() throws InterruptedException, NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();
        CadastroPageObject telaCadastro = telaLogin.IrParaTelaCadastro();
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Jonicler", "123", "1234");
        Thread.sleep(5000);

        Assert.assertEquals("Senhas não conferem", telaCadastro.erro());
        driver.navigate().back(); // Volta a tela anterior
    }

    @Test
    public  void cadastroSucesso() throws NoSuchElementException, InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        telaLogin = new LoginPageObject(driver);
        telaLogin.BuscarElementos();

        CadastroPageObject telaCadastro = telaLogin.IrParaTelaCadastro();
        telaCadastro.BuscarElementos();
        telaLogin = telaCadastro.Cadastrar("Joni", "123", "123");
        telaLogin.BuscarElementos();
        Thread.sleep(5000);



       // MobileElement validarCadastro = (MobileElement)driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
       // Assert.assertEquals("Id do usuário", validarCadastro.getText());

    }
}
