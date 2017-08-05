package javafxmvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Principal extends Application {
    
    public static void main(String[] args) {
        Application.launch(Principal.class, args);
        
    }
    
    @Override
    public void start(Stage stage) {
        AnchorPane FrmPrincipal = null;
        try {
            FrmPrincipal = FXMLLoader.load(getClass().getResource("visao/tela_principal.fxml"));
        } catch (Exception ex) {
            System.out.println("Exception on FXMLLoader.load()");
            System.out.println(ex.getMessage());  
        }

        stage.setTitle("Sistema de Controle de Maquinário");
        Scene scene = new Scene(FrmPrincipal);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
}