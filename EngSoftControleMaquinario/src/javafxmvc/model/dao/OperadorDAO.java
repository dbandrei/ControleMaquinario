package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxmvc.model.domain.Operador;

public class OperadorDAO {
    private Connection connection;
    String nome;
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Operador operador) {
        String sql = "INSERT INTO maquinario(nome, cnh, telefone)"
                +    "VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, operador.getNome());
            stmt.setString(2, operador.getCnh());
            stmt.setString(3, operador.getTelefone());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Operador operador) {
        String sql = "UPDATE operador SET nome=?, cnh=?, telefone=?"
                + "WHERE id_operador=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, operador.getNome());
            stmt.setString(2, operador.getCnh());
            stmt.setString(3, operador.getTelefone());
            stmt.setInt(4, operador.getIdOperador());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean remover(Operador operador) {
        String sql = "DELETE FROM operador WHERE id_operador=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, operador.getIdOperador());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    
    public List<Operador> listar() {
        String sql = "SELECT * FROM operador ORDER BY nome";
        List<Operador> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Operador operador = new Operador();
                operador.setIdOperador(resultado.getInt("id_operador"));
                operador.setNome(resultado.getString("nome"));
                operador.setCnh(resultado.getString("cnh"));
                operador.setTelefone(resultado.getString("telefone"));
                retorno.add(operador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Operador buscar(Operador operador) {
        String sql = "SELECT * FROM operador WHERE id_operador=?";
        Operador retorno = new Operador();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, operador.getIdOperador());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                operador.setIdOperador(resultado.getInt("id_operador"));
                operador.setNome(resultado.getString("nome"));
                operador.setCnh(resultado.getString("cnh"));
                operador.setTelefone(resultado.getString("operador"));
                retorno = operador;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public List<Operador> pesquisar(String nome) {
        this.nome = nome;
        String sql = "SELECT * FROM  operador WHERE UPPER(NOME) LIKE '%"+ nome +"%' ORDER BY nome";
        List<Operador> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Operador operador = new Operador();
                operador.setIdOperador(resultado.getInt("id_operador"));
                operador.setNome(resultado.getString("nome"));
                operador.setCnh(resultado.getString("cnh"));
                operador.setTelefone(resultado.getString("telefone"));
                retorno.add(operador);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
