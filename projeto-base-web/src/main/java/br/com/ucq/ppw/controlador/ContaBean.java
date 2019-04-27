package br.com.ucq.ppw.controlador;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ucq.ppw.modelo.Conta;
import br.com.ucq.ppw.modelo.Tipo;

@ManagedBean
public class ContaBean {

	private String mensagem = "String que veio do Controller";

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Conta> listarContas() {

		Conta conta1 = new Conta();
		conta1.setTitulo("Conta de energia");
		conta1.setDataPagamento(new Date());
		conta1.setDataVencimento(new Date());
		conta1.setTipo(Tipo.DESPESA);
		conta1.setValor(new BigDecimal("52.33"));

		Conta conta2 = new Conta();
		conta2.setTitulo("Conta de internet");
		conta2.setDataPagamento(new Date());
		conta2.setDataVencimento(new Date());
		conta2.setTipo(Tipo.DESPESA);
		conta2.setValor(new BigDecimal("110.00"));

		Conta conta3 = new Conta();
		conta3.setTitulo("Pagamento de salário");
		conta3.setDataPagamento(new Date());
		conta3.setDataVencimento(new Date());
		conta3.setTipo(Tipo.RECEITA);
		conta3.setValor(new BigDecimal("1529.99"));
		return Arrays.asList(conta1, conta2, conta3);
	}

}
