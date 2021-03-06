package br.edu.ucq.ppw.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.edu.ucq.ppw.bo.ContaBO;
import br.edu.ucq.ppw.excecao.RegraNegocioException;
import br.edu.ucq.ppw.modelo.Conta;
import br.edu.ucq.ppw.modelo.Tipo;

@ManagedBean
@ViewScoped
public class ContaController implements Serializable {

	private static final long serialVersionUID = -2643401591739123562L;

	private ContaBO bo = new ContaBO();
	private Conta conta = new Conta();
	private List<Conta> contas;

	@PostConstruct
	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String indice = req.getParameter("id");
		if (indice != null && String.valueOf(indice).matches("\\d+"))
			conta = bo.contaPorId(Long.valueOf(indice));
	}

	public String adicionar() {
		try {
			bo.adicionar(conta);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Conta cadastrada com sucesso"));
			conta = new Conta();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		}
		return "/conta/cadastrar-conta";
	}

	public String atualizar() {
		try {
			bo.atualizar(conta);
			FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Conta atualizada com sucesso"));
			conta = new Conta();
		} catch (RegraNegocioException e) {
			FacesContext.getCurrentInstance().addMessage("msgs",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return null;
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		}
		return "/conta/listar-contas.xhtml?faces-redirect=true";
	}

	public void deletar(Conta conta) {
		bo.deletar(conta);
		FacesContext.getCurrentInstance().addMessage("msgs", new FacesMessage("Conta removida com sucesso"));
	}

	public Conta getConta() {
		return conta;
	}

	public Tipo[] tipos() {
		return Tipo.values();
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getContas() {
		if (contas == null) {
			contas = bo.listarTodos();
		}
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
