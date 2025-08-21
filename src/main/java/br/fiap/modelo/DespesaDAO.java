package br.fiap.modelo;

import br.fiap.conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    //ATRIBUTOS
    // Ela é sabe onde está o banco de dados, como chegar até o banco
    // e transporta nossos comandos para dentro do banco
    private PreparedStatement ps;
    //Mostra o resultado das nossas inserções dentro do SQL
    private ResultSet rs;
    private String sql;

    //METODOS
    public void inserir(Despesa despesa){
        sql = "insert into java_despesa values (?, ?, ?, ?, ?)";

        try(Connection connection = Conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            //Abaixo configuramos cada uma das "?" com seu determinado elemento
            ps.setLong(1, despesa.getId());
            ps.setString(2, despesa.getDescricao());
            ps.setDouble(3, despesa.getValor());
            ps.setDate(4, Date.valueOf(despesa.getData()));
            ps.setLong(5, despesa.getCategoria().getId());
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Erro ao inserir despesa\n" + e);
        }
    }

    public List<Despesa> listar(){
        List<Despesa> lista = new ArrayList<>();
        sql = "select * from java_despesa";
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
           while(rs.next()){
               Despesa despesa = new Despesa();
               despesa.setId(rs.getLong("id_despesa"));
               despesa.setDescricao(rs.getString("descricao"));
               despesa.setValor(rs.getDouble("valor"));
               despesa.setData(rs.getDate("data").toLocalDate());
               despesa.setCategoria(new Categoria(rs.getLong("id_categoria"), ""));
               lista.add(despesa);
           }
        }
        catch (SQLException e){
            System.out.println("Erro ao listar despesas\n" + e);
        }
        return lista;
    }
}
