package br.com.nameproject.configuration.models;

import br.com.nameproject.configuration.suporte.EnumAmbiente;
import br.com.nameproject.configuration.suporte.EnumNavegador;

public class ConfiguracaoAmbiente {

	public ConfiguracaoAmbiente() {
		this.navegador = EnumNavegador.FIREFOX;
		this.ambiente = EnumAmbiente.LOCAL;
	}

	public Enum<?> navegador;
	public Enum<?> ambiente;

	public void setNavegador(Enum<?> Navegador) {
		this.navegador = Navegador;
	}

	public Enum<?> getNavegador() {
		return navegador;
	}

	public Enum<?> getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Enum<?> ambiente) {
		this.ambiente = ambiente;
	}

}
