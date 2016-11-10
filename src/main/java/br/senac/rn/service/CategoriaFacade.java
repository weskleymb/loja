package br.senac.rn.service;

import java.util.List;
import br.senac.rn.dao.CategoriaDAO;
import br.senac.rn.model.Categoria;
import javax.jws.WebService;

@WebService
public class CategoriaFacade {

    private CategoriaDAO dao;

    public CategoriaFacade() {
        dao = new CategoriaDAO();
    }
    
    public List<Categoria> findAll() {
        return dao.findAll();
    }
    
    public void create(Categoria categoria) {
        dao.create(categoria);
    }
	
}