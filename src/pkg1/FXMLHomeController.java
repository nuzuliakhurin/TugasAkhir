/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nuzulia Khurin
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private JFXTextField NamaLengkap;
    @FXML
    private JFXTextField Alamat;
    @FXML
    private JFXTextField NoTelp;
    @FXML
    private JFXTextField Jumlah;

    @FXML
    private JFXButton submit;

    @FXML
    private RadioButton lunas;

    @FXML
    private ToggleGroup an;

    @FXML
    private RadioButton blmlunas;

    @FXML
    private RadioButton katun;

    @FXML
    private ToggleGroup on;

    @FXML
    private RadioButton parasit;

    @FXML
    private RadioButton warna;

    @FXML
    private ToggleGroup in;

    @FXML
    private JFXTextField diskon;
    
    @FXML
    private JFXTextArea hasil;
    
    @FXML
    private RadioButton putih;
    
    @FXML
    private JFXDatePicker tgl_laundry;

    @FXML
    private JFXDatePicker tgl_selesai;

    int harga = 5000;
    String nama, alamat, telp, tgl_laun, tgl_sls, jmlh,Diskon, a, b, c, d;
    int total, subtotal, temp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    void kirim(){
         if(NamaLengkap.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan nama lengkap Anda");
        }else if (Alamat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap isikan Alamat Anda");
            }else if (NoTelp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap isikan nomor telpon Anda");
            }else if (Jumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap isikan jumlah mukenah");
            }else if(tgl_laundry.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Harap pilih Tanggal Laundry");
            }else if(tgl_selesai.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Harap pilih Tanggal Selesai");
            }
         
            nama = NamaLengkap.getText();
            alamat = Alamat.getText();
            telp = NoTelp.getText();
            tgl_laun = tgl_laundry.getValue().toString();
            tgl_sls = tgl_selesai.getValue().toString();
            jmlh = Jumlah.getText();
            Diskon = diskon.getText();
            total = Integer.parseInt(jmlh)*5000;
            temp = total * Integer.parseInt(Diskon) / 100;
            subtotal = total - temp;
            a = katun.getText();
            b = parasit.getText();
            c = warna.getText();
            d = putih.getText();
    }
    String Jenis;
    void hasil(){
        if (katun.isSelected() && warna.isSelected()){
            Jenis = a + " "+c;
        } else if(katun.isSelected() && putih.isSelected()){
            Jenis = a + " " +d;
        } else if(parasit.isSelected() && warna.isSelected()){
            Jenis = b + " "+c;
        }else {
            Jenis = b + " " + d;
        }
    }

    @FXML
    private void proses(ActionEvent event) {
            kirim();
            hasil();
           try {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLLanjutan.fxml"));
            
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Nota");
            stage.setResizable(false);
            stage.show();
            
            FXMLLanjutanController Data = new FXMLLanjutanController();
            Data = fxmlLoader.getController();
            
            Data.setdata(nama, alamat, telp,Jenis, tgl_laun, tgl_sls, jmlh,Diskon,total,subtotal);
            
        } catch (IOException e) {
            System.out.println("Batal membuat window baru" + e);
        }
    }
    
}
