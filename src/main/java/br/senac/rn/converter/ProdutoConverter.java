package br.senac.rn.converter;

import br.senac.rn.dao.ProdutoDAO;
import br.senac.rn.model.Produto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "produtoConverter", forClass = Produto.class)
public class ProdutoConverter implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            ProdutoDAO dao = new ProdutoDAO();
            return (Object) dao.findByPrimaryKey(Integer.parseInt(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object != null) {
            return String.valueOf(((Produto) object).getId());
        }
        return null;
    }
    
}
