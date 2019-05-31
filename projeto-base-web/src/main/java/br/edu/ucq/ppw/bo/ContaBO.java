package br.edu.ucq.ppw.bo;

import java.util.List;

import br.edu.ucq.ppw.dao.ContaDAO;
import br.edu.ucq.ppw.modelo.Conta;

public class ContaBO {

	private ContaDAO dao = new ContaDAO();

	public void adicionar(Conta conta) {
		validar(conta);
		dao.adicionar(conta);
	}

	private void validar(Conta conta) {
		if (conta.getTitulo().length() < 10) {
			throw new RuntimeException("Tamanho de título é inválido. Não pode ser menor do que 10");
		}

	}

	public void atualizar(Conta conta) {
		validar(conta);
		dao.atualizar(conta);
	}

	public void deletar(Conta conta) {
		dao.deletar(conta);
	}

	public List<Conta> listarTodos() {
		return dao.listarTodos();
	}

	public Conta contaPorId(Long indice) {
		return dao.contaPorId(indice);
	}
}