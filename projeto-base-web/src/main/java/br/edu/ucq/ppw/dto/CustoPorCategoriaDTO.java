package br.edu.ucq.ppw.dto;

import java.math.BigDecimal;

public class CustoPorCategoriaDTO {

	private String categoria;
	private BigDecimal total;

	public CustoPorCategoriaDTO(String categoria, BigDecimal total) {
		super();
		this.categoria = categoria;
		this.total = total;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
