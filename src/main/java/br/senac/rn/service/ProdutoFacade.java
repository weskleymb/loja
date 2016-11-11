package br.senac.rn.service;

import java.util.List;
import br.senac.rn.dao.ProdutoDAO;
import br.senac.rn.model.Produto;
import javax.jws.WebService;

@WebService(name = "produtoService")
public class ProdutoFacade {
    
    private ProdutoDAO dao;

    public ProdutoFacade() {
        dao = new ProdutoDAO();
    }

    public List<Produto> findAll() {
        return dao.findAll();
    }
	
}
