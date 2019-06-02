package br.edu.ucq.ppw.controlador;

import static br.edu.ucq.ppw.modelo.Tipo.DESPESA;
import static br.edu.ucq.ppw.modelo.Tipo.RECEITA;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;

import br.edu.ucq.ppw.bo.ContaBO;
import br.edu.ucq.ppw.modelo.Categoria;

@ManagedBean
public class HomeController {

	private ContaBO contaBo = new ContaBO();

	public String custoPorCategoriaReceitas() {
		StringBuilder stringBuilder = new StringBuilder();
		Map<Categoria, BigDecimal> custoPorCategoria = contaBo.custoPorCategoria(RECEITA);
		for (Entry<Categoria, BigDecimal> e : custoPorCategoria.entrySet()) {
			stringBuilder.append("[");
			stringBuilder.append("'");
			stringBuilder.append(e.getKey().getNome());
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append(e.getValue());
			stringBuilder.append("]");
			stringBuilder.append(",");

		}
		return stringBuilder.toString();
	}

	public String custoPorCategoriaDespesas() {
		StringBuilder stringBuilder = new StringBuilder();
		Map<Categoria, BigDecimal> custoPorCategoria = contaBo.custoPorCategoria(DESPESA);
		for (Entry<Categoria, BigDecimal> e : custoPorCategoria.entrySet()) {
			stringBuilder.append("[");
			stringBuilder.append("'");
			stringBuilder.append(e.getKey().getNome());
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append(e.getValue());
			stringBuilder.append("]");
			stringBuilder.append(",");

		}
		return stringBuilder.toString();
	}

}
