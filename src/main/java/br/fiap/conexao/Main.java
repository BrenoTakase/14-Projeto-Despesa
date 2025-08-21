package br.fiap.conexao;

import br.fiap.modelo.Categoria;
import br.fiap.modelo.CategoriaDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Testar conexão
        //System.out.println(Conexao.conectar());

        //Traz os objetos de CategoriaDAO
        CategoriaDAO dao = new CategoriaDAO();
        //Coloca os elementos dentro dos atributos de Categoria
        //Categoria categoria = new Categoria(3L, "educação");
        //Chama o metodo de inserir no banco de dados
        //dao.inserir(categoria);

        //Chama e mostra a Lista do BD
        List<Categoria> lista = dao.listar();
        for (Categoria categoria : lista){
            System.out.println(categoria.getId() +"  --> " + categoria.getCategoria());
        }
    }
}
