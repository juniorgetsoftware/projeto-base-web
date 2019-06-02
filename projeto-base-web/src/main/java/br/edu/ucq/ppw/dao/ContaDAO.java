package br.edu.ucq.ppw.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.edu.ucq.ppw.modelo.Categoria;
import br.edu.ucq.ppw.modelo.Conta;
import br.edu.ucq.ppw.modelo.Tipo;

public class ContaDAO {

	private static List<Conta> contasDb = new ArrayList<>();

	public void adicionar(Conta conta) {
		conta.setId(Long.valueOf(contasDb.size()));
		contasDb.add(conta);
	}

	public void atualizar(Conta conta) {
		int indice = contasDb.indexOf(conta);
		if (indice == -1) {
			throw new RuntimeException("Não foi possível encontrar a conta.");
		}
		contasDb.set(indice, conta);
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

	public Conta contaPorId(Long indice) {
		return contasDb.stream().filter(c -> c.getId().equals(indice)).findFirst().orElse(null);
	}

	public Map<Categoria, BigDecimal> custoPorCategoria(Tipo tipo) {
		return contasDb.stream().filter(c -> tipo.equals(c.getTipo())).collect(Collectors.groupingBy(Conta::getCategoria,
				Collectors.reducing(BigDecimal.ZERO, Conta::getValor, BigDecimal::add)));
	}

}
