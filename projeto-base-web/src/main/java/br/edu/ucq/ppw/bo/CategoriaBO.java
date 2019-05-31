package br.edu.ucq.ppw.bo;

import java.util.List;

import br.edu.ucq.ppw.dao.CategoriaDAO;
import br.edu.ucq.ppw.excecao.RegraNegocioException;
import br.edu.ucq.ppw.modelo.Categoria;

public class CategoriaBO {

	private CategoriaDAO dao = new CategoriaDAO();

	public void adicionar(Categoria categoria) throws RegraNegocioException {
		validar(categoria);
		dao.adicionar(categoria);
	}

	private void validar(Categoria categoria) throws RegraNegocioException {
		if (categoria.getNome().length() < 10) {
			throw new RegraNegocioException("Nome da categoria é inválida. Não pode ser menor do que 10");
		}

	}

	public void atualizar(Categoria categoria) throws RegraNegocioException {
		validar(categoria);
		dao.atualizar(categoria);
	}

	public void deletar(Categoria categoria) {
		dao.deletar(categoria);
	}

	public List<Categoria> listarTodos() {
		return dao.listarTodos();
	}

	public Categoria categoriaPorId(Long indice) {
		return dao.categoriaPorId(indice);
	}
}
