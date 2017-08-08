package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxmvc.model.domain.Maquinario;

public class MaquinarioDAO {
    private Connection connection;
    String nome;
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Maquinario maquinario) {
        String sql = "INSERT INTO maquinario(nome, marca, ano, chassi, observacao)"
                +    "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, maquinario.getNome());
            stmt.setString(2, maquinario.getMarca());
            stmt.setString(3, maquinario.getAno());
            stmt.setString(4, maquinario.getChassi());
            stmt.setString(5, maquinario.getObservacao());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MaquinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Maquinario maquinario) {
        String sql = "UPDATE maquinario SET nome=?, marca=?, ano=?, chassi=?, observacao=?"
                + "WHERE id_maquinario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, maquinario.getNome());
            stmt.setString(2, maquinario.getMarca());
            stmt.setString(3, maquinario.getAno());
            stmt.setString(4, maquinario.getChassi());
            stmt.setString(5, maquinario.getObservacao());
            stmt.setInt(6, maquinario.getIdMaquinario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MaquinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//    nome, marca, ano, chassi, observacao
    public boolean remover(Maquinario maquinario) {
        String sql = "DELETE FROM maquinario WHERE id_maquinario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maquinario.getIdMaquinario());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MaquinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    //    nome, marca, ano, chassi, observacao
    public List<Maquinario> listar() {
        String sql = "SELECT * FROM maquinario ORDER BY nome";
        List<Maquinario> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Maquinario maquinario = new Maquinario();
                maquinario.setIdMaquinario(resultado.getInt("id_maquinario"));
                maquinario.setNome(resultado.getString("nome"));
                maquinario.setMarca(resultado.getString("marca"));
                maquinario.setAno(resultado.getString("ano"));
                maquinario.setChassi(resultado.getString("chassi"));
                maquinario.setObservacao(resultado.getString("observacao"));
                retorno.add(maquinario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public Maquinario buscar(Maquinario maquinario) {
        String sql = "SELECT * FROM departamento WHERE id_departamento=?";
        Maquinario retorno = new Maquinario();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maquinario.getIdMaquinario());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                maquinario.setIdMaquinario(resultado.getInt("id_maquinario"));
                maquinario.setNome(resultado.getString("nome"));
                maquinario.setMarca(resultado.getString("marca"));
                maquinario.setAno(resultado.getString("ano"));
                maquinario.setChassi(resultado.getString("chassi"));
                maquinario.setObservacao(resultado.getString("observacao"));
                retorno = maquinario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    public List<Maquinario> pesquisar(String nome) {
        this.nome = nome;
        String sql = "SELECT * FROM  maquinario WHERE UPPER(NOME) LIKE '%"+ nome +"%' ORDER BY nome";
        List<Maquinario> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Maquinario maquinario = new Maquinario();
                maquinario.setIdMaquinario(resultado.getInt("id_maquinario"));
                maquinario.setNome(resultado.getString("nome"));
                maquinario.setMarca(resultado.getString("marca"));
                maquinario.setAno(resultado.getString("ano"));
                maquinario.setChassi(resultado.getString("chassi"));
                maquinario.setObservacao(resultado.getString("observacao"));
                retorno.add(maquinario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaquinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
