package br.com.ucq.ppw.controlador;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ContaBean {

	private String mensagem ;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
