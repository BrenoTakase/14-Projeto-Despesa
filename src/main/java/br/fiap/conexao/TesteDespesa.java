package br.fiap.conexao;

import br.fiap.modelo.Categoria;
import br.fiap.modelo.Despesa;
import br.fiap.modelo.DespesaDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TesteDespesa {
    public static void main(String[] args) {

        //Traz os objetos de CategoriaDAO
        DespesaDAO dao = new DespesaDAO();
        //Parecido com o DF, mas para data
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//        Despesa despesa = new Despesa();
//        despesa.setId(103L);
//        despesa.setDescricao("Monster para assistir na aula");
//        despesa.setValor(78.00);
//        despesa.setData(LocalDate.parse("21/08/2025", mascara));
//        despesa.setCategoria(new Categoria(3L, ""));
//        dao.inserir(despesa); //Ctrl + / coloca tudo selecionado em comentário

        List<Despesa> lista = dao.listar();
        for (Despesa despesa: lista){
            System.out.println(despesa.getId());
            System.out.println(despesa.getDescricao());
            System.out.println(despesa.getValor());
            System.out.println(despesa.getData());
            System.out.println(despesa.getCategoria().getId());
            System.out.println("=============================");
        }
    }
}
