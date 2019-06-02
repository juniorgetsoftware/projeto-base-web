package br.edu.ucq.ppw.bo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import br.edu.ucq.ppw.dao.ContaDAO;
import br.edu.ucq.ppw.excecao.RegraNegocioException;
import br.edu.ucq.ppw.modelo.Categoria;
import br.edu.ucq.ppw.modelo.Conta;
import br.edu.ucq.ppw.modelo.Tipo;

public class ContaBO {

	private ContaDAO dao = new ContaDAO();

	public void adicionar(Conta conta) throws RegraNegocioException {
		validar(conta);
		dao.adicionar(conta);
	}

	private void validar(Conta conta) throws RegraNegocioException {
		if (conta.getTitulo().length() < 10) {
			throw new RegraNegocioException("Tamanho de título é inválido. Não pode ser menor do que 10");
		}

	}

	public void atualizar(Conta conta) throws RegraNegocioException {
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

	public Map<Categoria, BigDecimal> custoPorCategoria(Tipo tipo) {
		return dao.custoPorCategoria(tipo);
	}
}
