package br.com.ucq.ppw.controlador;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ucq.ppw.bo.ContaBO;
import br.com.ucq.ppw.modelo.Conta;
import br.com.ucq.ppw.modelo.Tipo;

@ManagedBean
public class ContaBean {

	private ContaBO bo = new ContaBO();
	private Conta conta = new Conta();
	private List<Conta> contas;

	public void adicionar() {
		bo.adicionar(conta);
		FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Conta cadastrada com sucesso"));
	}

	public Conta getConta() {
		return conta;
	}

	public Tipo[] tipos() {
		return Tipo.values();
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getContas() {
		if (contas == null) {
			contas = bo.listarTodos();
		}
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
