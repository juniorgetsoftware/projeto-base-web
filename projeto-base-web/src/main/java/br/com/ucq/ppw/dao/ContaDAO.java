package br.com.ucq.ppw.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.ucq.ppw.modelo.Conta;

public class ContaDAO {

	private static List<Conta> contasDb = new ArrayList<>();

	public void adicionar(Conta conta) {
		conta.setId(contasDb.size() + 1l);
		contasDb.add(conta);
	}

	public void atualizar(Conta conta) {
		int indice = contasDb.indexOf(conta);
		if (indice == -1) {
			throw new RuntimeException("Não foi possível encontrar a conta.");
		}
		contasDb.add(conta);
	}

	public void deletar(Conta conta) {
		int indice = contasDb.indexOf(conta);
		if (indice == -1) {
			throw new RuntimeException("Não foi possível encontrar a conta.");
		}
		contasDb.remove(indice);
	}

	public List<Conta> listarTodos() {
		return contasDb;
	}

}
