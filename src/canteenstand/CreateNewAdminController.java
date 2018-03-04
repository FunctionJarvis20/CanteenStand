/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteenstand;

import canteenstand.database.Database;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CreateNewAdminController implements Initializable{

        @FXML
        private AnchorPane createnewadmin;
        @FXML
        private JFXTextField full_name;
        @FXML
        private JFXTextField email_address;
        @FXML
        private JFXTextField create_username;
        @FXML
        private JFXTextField create_password;

        /**
         * Initializes the controller class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {
                // TODO
        }        

        @FXML
        private void createAdminAccount(ActionEvent event) throws IOException, SQLException {
                 ((Node)event.getSource()).getScene().getWindow().hide();
                String adminfullname=full_name.getText();
                String adminemailaddress=email_address.getText();
                String adminusername=create_username.getText();
                String adminpassword=create_password.getText();
                Database db=new Database();
                if(Database.createNewAdmin(adminfullname,  adminusername, adminpassword,adminemailaddress))
                {
                        Notifications success=Notifications.create();
                        success.title("Admin Created ");
	    success.text("Admin successfully created");
                        success.hideAfter(Duration.seconds(2));
                        success.darkStyle();
                        success.position(Pos.CENTER);
                        success.showInformation();
                }
                else
                {
                        Notifications failed=Notifications.create();
			failed.title("Failed ");
			failed.text("Failed To Create");
			failed.hideAfter(Duration.seconds(2));
			failed.darkStyle();
			failed.position(Pos.CENTER);
			failed.showError();
                }
                
}

        
}
