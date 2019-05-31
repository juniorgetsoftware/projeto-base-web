package br.edu.ucq.ppw.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ucq.ppw.modelo.Categoria;

@FacesConverter(forClass = Categoria.class, value = "categoriaConverter")
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.isEmpty())
			return null;
		return arg1.getAttributes().get(string);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		Categoria categoria = (Categoria) object;
		if (categoria == null || categoria.getId() == null)
			return null;
		arg1.getAttributes().put(String.valueOf(categoria.getId()), categoria);
		return String.valueOf(categoria.getId());
	}

}