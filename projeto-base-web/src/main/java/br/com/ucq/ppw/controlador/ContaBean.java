package br.com.ucq.ppw.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ucq.ppw.bo.ContaBO;
import br.com.ucq.ppw.modelo.Conta;

@ManagedBean
public class ContaBean {

	private ContaBO bo = new ContaBO();
	private Conta conta = new Conta();
	private List<Conta> contas;

	public void adicionar() {
		bo.adicionar(conta);
	}

	public Conta getConta() {
		return conta;
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
