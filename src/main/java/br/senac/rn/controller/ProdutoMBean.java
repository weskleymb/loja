package br.senac.rn.controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import br.senac.rn.dao.ProdutoDAO;
import br.senac.rn.model.Produto;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProdutoMBean extends AbstractController<Produto> {
	
    private Produto produto = new Produto();
    private List<Produto> produtos;
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public List<Produto> getProdutos() {
        if (produtos == null) {
            ProdutoDAO dao = new ProdutoDAO();
            produtos = dao.findAll();
        }
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    } 

    public String salvar() {
        ProdutoDAO dao = new ProdutoDAO();
        if (produto.getId()==0) {
            dao.create(produto);
            produtos.add(produto);
        } else {
            dao.update(produto);
        }
        addInfo("Produto salvo com sucesso!");
        produto = new Produto();
        return null;
    }

    public String selecionar(Produto produto){
        this.produto = produto;
        return null;
    }

    public String deletar(Produto produto) {
        ProdutoDAO dao = new ProdutoDAO();
        dao.delete(produto);
        produtos.remove(produto);
        addInfo("Produto apagado com sucesso!");
        return null;
    }
	
}
