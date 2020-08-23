package br.com.nameproject.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.nameproject.scenario.mantercadastro.Test_ManterCadastro_RealizarCadastro;
import br.com.nameproject.scenario.mantercadastro.Test_ManterCadastro_ValidarCamposObrigatorios;
import br.com.nameproject.scenario.mantercadastro.Test_ManterCadastro_ValidarRegistroDuplicado;

@RunWith(Suite.class)
@SuiteClasses({
	Test_ManterCadastro_ValidarCamposObrigatorios.class,
	Test_ManterCadastro_ValidarRegistroDuplicado.class,
	Test_ManterCadastro_RealizarCadastro.class
})
public class Suite_001_ManterCadastro {

}
