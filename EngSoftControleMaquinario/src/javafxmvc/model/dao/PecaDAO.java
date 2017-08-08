package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxmvc.model.domain.Peca;

public class PecaDAO {
    private Connection connection;
    String nome;
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Peca peca) {
        String sql = "INSERT INTO peca(nome, marca, descricao)"
                +    "VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getMarca());
            stmt.setString(3, peca.getDescricao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Peca peca) {
        String sql = "UPDATE peca SET nome=?, marca=?, descricao=?"
                + "WHERE id_peca=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, peca.getNome());
            stmt.setString(2, peca.getMarca());
            stmt.setString(3, peca.getDescricao());
            stmt.setInt(4, peca.getIdPeca());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean remover(Peca peca) {
        String sql = "DELETE FROM peca WHERE id_peca=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, peca.getIdPeca());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PecaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    
    public List<Peca> listar() {
        String sql = "SELECT * FROM peca ORDER BY nome";
        List<Peca> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Peca peca = new Peca();
                peca.setIdPeca(resultado.getInt("id_peca"));
                peca.setNome(resultado.getString("nome"));
                peca.setMarca(resultado.getString("marca"));
                peca.setDescricao(resultado.getString("descricao"));
                retorno.add(peca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PecaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Peca buscar(Peca peca) {
        String sql = "SELECT * FROM peca WHERE id_peca=?";
        Peca retorno = new Peca();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, peca.getIdPeca());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                peca.setIdPeca(resultado.getInt("id_peca"));
                peca.setNome(resultado.getString("nome"));
                peca.setMarca(resultado.getString("marca"));
                peca.setDescricao(resultado.getString("descricao"));
                retorno = peca;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PecaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public List<Peca> pesquisar(String nome) {
        this.nome = nome;
        String sql = "SELECT * FROM peca WHERE UPPER(NOME) LIKE '%"+ nome +"%' ORDER BY nome";
        List<Peca> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Peca peca = new Peca();
                peca.setIdPeca(resultado.getInt("id_peca"));
                peca.setNome(resultado.getString("nome"));
                peca.setMarca(resultado.getString("marca"));
                peca.setDescricao(resultado.getString("descricao"));
                retorno.add(peca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PecaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
