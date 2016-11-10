package br.senac.rn.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import br.senac.rn.dao.CategoriaDAO;
import br.senac.rn.model.Categoria;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "categoriaMBean")
public class CategoriaMBean extends AbstractController<Categoria> {

    private Categoria categoria = new Categoria();
    private List<Categoria> categorias;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public List<Categoria> getCategorias() {
        CategoriaDAO dao = new CategoriaDAO();
        if (categorias == null) {
            categorias = dao.findAll();
        }
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String salvar() {
        CategoriaDAO dao = new CategoriaDAO();
        if (categoria.getId()==0) {
            dao.create(categoria);
            categorias.add(categoria);
        } else {
            dao.update(categoria);
        }
        addInfo("Categoria salva com sucesso!");
        categoria = new Categoria();
        return null;
    }

    public String selecionar(Categoria categoria) {
        this.categoria = categoria;
        return null;
    }

    public String deletar(Categoria categoria) {
        CategoriaDAO dao = new CategoriaDAO();
        dao.delete(categoria);
        categorias.remove(categoria);
        addInfo("Categoria apagada com sucesso!");
        return null;
    }
	
}