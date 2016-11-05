package br.senac.rn.converter;

import br.senac.rn.dao.CategoriaDAO;
import br.senac.rn.model.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoriaConverter", forClass = Categoria.class)
public class CategoriaConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            CategoriaDAO dao = new CategoriaDAO();
            return (Object) dao.findByPrimaryKey(Integer.parseInt(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null) {
            return String.valueOf(((Categoria) object).getId());
        }
        return null;
    }

    
}
