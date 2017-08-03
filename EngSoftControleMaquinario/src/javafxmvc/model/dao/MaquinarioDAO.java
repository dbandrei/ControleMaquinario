package javafxmvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String sql = "INSERT INTO cargo(nome, marca, ano, chassi, observacao)"
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
        String sql = "UPDATE departamento SET nome=?, marca=?, ano=?, chassi=?, observacao=?"
                + "WHERE id_maquinario=?";
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

//    nome, marca, ano, chassi, observacao
    public boolean remover(Maquinario maquinario) {
        String sql = "DELETE FROM departamento WHERE id_maquinario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maquinario.getIdMaquinairo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MaquinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }    
}
