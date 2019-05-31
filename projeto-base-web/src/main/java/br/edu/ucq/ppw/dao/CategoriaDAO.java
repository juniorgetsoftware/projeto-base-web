package br.edu.ucq.ppw.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ucq.ppw.modelo.Categoria;

public class CategoriaDAO {

	private static List<Categoria> categoriasDb = new ArrayList<>();

	public void adicionar(Categoria categoria) {
		categoria.setId(Long.valueOf(categoriasDb.size()));
		categoriasDb.add(categoria);
	}

	public void atualizar(Categoria categoria) {
		int indice = categoriasDb.indexOf(categoria);
		if (indice == -1) {
			throw new RuntimeException("Não foi possível encontrar a categoria.");
		}
		categoriasDb.set(indice, categoria);
	}

	public void deletar(Categoria categoria) {
		int indice = categoriasDb.indexOf(categoria);
		if (indice == -1) {
			throw new RuntimeException("Não foi possível encontrar a categoria.");
		}
		categoriasDb.remove(indice);
	}

	public List<Categoria> listarTodos() {
		return categoriasDb;
	}

	public Categoria categoriaPorId(Long indice) {
		return categoriasDb.stream().filter(c -> c.getId().equals(indice)).findFirst().orElse(null);
	}

}
