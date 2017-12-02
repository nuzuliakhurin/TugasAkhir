/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Component;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nuzulia Khurin
 */
public class FXMLLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField Username;

    @FXML
    private JFXPasswordField Password;
    
    @FXML
    private JFXButton login;
    
    @FXML
    void proses(ActionEvent event) throws IOException {
         Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laundry", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `login` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, Username.getText());
            ps.setString(2, Password.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Benar");
             ((Node) (event.getSource())).getScene().getWindow().hide();
             FXMLLoader fxmlLoader= new FXMLLoader();
             fxmlLoader.setLocation(getClass().getResource("FXMLHome.fxml"));
             Scene scene = new Scene(fxmlLoader.load(), 500, 650);
             Stage stage = new Stage();
             stage.setScene(scene);
             stage.setTitle("Pure Laudry");
             stage.setResizable(false);
             stage.show();
             
            }else if (Username.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Username tidak boleh Kosong!");
            }else if (Password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password tidak boleh Kosong!");
            }else if (Username.getText().equals("") && Password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh Kosong!");
            }else  {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                Username.setText("");
                Password.requestFocus();
            }
        } catch (SQLException ex) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Gagal!");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
