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
import javafxmvc.model.domain.Talhao;

public class TalhaoDAO {
    private Connection connection;
    String nome;
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Talhao talhao) {
        String sql = "INSERT INTO talhao(descricao)"
                +    "VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, talhao.getDescricao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TalhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Talhao talhao) {
        String sql = "UPDATE talhao SET nome=?"
                + "WHERE id_talhao=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, talhao.getDescricao());
            stmt.setInt(2, talhao.getIdTalhao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TalhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean remover(Talhao talhao) {
        String sql = "DELETE FROM talhao WHERE id_talhao=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, talhao.getIdTalhao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TalhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Talhao> listar() {
        String sql = "SELECT * FROM talhao ORDER BY nome";
        List<Talhao> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Talhao talhao = new Talhao();
                talhao.setIdTalhao(resultado.getInt("id_talhao"));
                talhao.setDescricao(resultado.getString("descricao"));
                retorno.add(talhao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TalhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Talhao buscar(Talhao talhao) {
        String sql = "SELECT * FROM talhao WHERE id_talhao=?";
        Talhao retorno = new Talhao();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, talhao.getIdTalhao());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                talhao.setIdTalhao(resultado.getInt("id_talhao"));
                talhao.setDescricao(resultado.getString("descricao"));
                retorno = talhao;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TalhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public List<Talhao> pesquisar(String nome) {
        this.nome = nome;
        String sql = "SELECT * FROM talhao WHERE UPPER(NOME) LIKE '%"+ nome +"%' ORDER BY nome";
        List<Talhao> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Talhao talhao = new Talhao();
                talhao.setIdTalhao(resultado.getInt("id_talhao"));
                talhao.setDescricao(resultado.getString("descricao"));
                retorno.add(talhao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TalhaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
