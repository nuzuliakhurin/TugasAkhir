/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nuzulia Khurin
 */
public class FXMLLanjutanController implements Initializable {

    @FXML
    private JFXTextField jml;
    @FXML
    private JFXTextField ttl;
    @FXML
    private JFXTextField dskn;
    @FXML
    private JFXTextField subttl;
    @FXML
    private JFXTextField bayar;
    @FXML
    private JFXButton hasil;
    @FXML
    private JFXTextField namaa;
    @FXML
    private JFXTextField alamatt;
    @FXML
    private JFXTextField telpp;
    @FXML
    private JFXTextField tg_laun;
    @FXML
    private JFXTextField tg_sls;
    @FXML
    private JFXTextField jenis;
     @FXML
    private JFXTextField kembali;

      @FXML
    private JFXButton exit;

    
     String byr ,sub;
     int sisa;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void proses(ActionEvent event) {
       byr = bayar.getText();
         sub = subttl.getText();
         sisa = Integer.parseInt(byr) - Integer.parseInt(sub);
         kembali.setText(String.valueOf(sisa));
    }

    void setdata(String nama, String alamat, String telp, String Jenis, String tgl_laun, String tgl_sls, String jmlh, String Diskon, int total, int subtotal) {
       namaa.setText(nama);
       alamatt.setText(alamat);
       telpp.setText(telp);
       tg_laun.setText(tgl_laun);
       tg_sls.setText(tgl_sls);
       jml.setText(jmlh);
       dskn.setText(Diskon);
       ttl.setText(String.valueOf(total));
       subttl.setText(String.valueOf(subtotal));
       jenis.setText(Jenis);
       
    }
    @FXML
    void exit(ActionEvent event) {
         Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }


}
