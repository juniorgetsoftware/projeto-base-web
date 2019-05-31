package br.edu.ucq.ppw.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.edu.ucq.ppw.bo.CategoriaBO;
import br.edu.ucq.ppw.excecao.RegraNegocioException;
import br.edu.ucq.ppw.modelo.Categoria;
import br.edu.ucq.ppw.modelo.Tipo;

@ManagedBean
@ViewScoped
public class CategoriaController implements Serializable {

	private static final long serialVersionUID = -2643401591739123562L;

	private CategoriaBO bo = new CategoriaBO();
	private Categoria categoria = new Categoria();
	private List<Categoria> categorias;

	@PostConstruct
	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String indice = req.getParameter("id");
		if (indice != null && String.valueOf(indice).matches("\\d+"))
			categoria = bo.categoriaPorId(Long.valueOf(indice));
	}

	public String adicionar() {
		try {
			bo.adicionar(categoria);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Categoria cadastrada com sucesso"));
			categoria = new Categoria();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
		return "/categoria/cadastrar-categoria";
	}

	public String atualizar() {
		try {
			bo.atualizar(categoria);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Categoria atualizada com sucesso"));
			categoria = new Categoria();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
		return "/categoria/listar-categorias.xhtml?faces-redirect=true";
	}

	public void deletar(Categoria categoria) {
		bo.deletar(categoria);
		FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Categoria removida com sucesso"));
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Tipo[] tipos() {
		return Tipo.values();
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		if (categorias == null) {
			categorias = bo.listarTodos();
		}
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
