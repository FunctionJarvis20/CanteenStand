/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteenstand;

import canteenstand.database.Database;
import canteenstand.staff.TakeNewOrderController;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class StartApplicationController implements Initializable {

        @FXML
        private WebView webview;
        @FXML
        private JFXTextField admin_username;
        @FXML
        private JFXTextField admin_password;
        @FXML
        private AnchorPane adminlogin;
        @FXML
        private AnchorPane adminloginscreen;
        @FXML
        private JFXTextField staff_username1;
        @FXML
        private JFXTextField staff_password1;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                WebEngine webengine = webview.getEngine();
                webengine.load("https://www.google.com/");
        }

        @FXML
        private void adminLogin(ActionEvent event) throws Exception, ClassNotFoundException {
               String u="";
               String p="";
                String s = admin_username.getText();
                String s2 = admin_password.getText();
              
                String URL = "jdbc:mysql://localhost:3306/canteenapplication?autoReconnect=true&useSSL=false";
                String pass = "ActiveJarvis20";
                String user = "FunctionJarvis20";
                String query = "SELECT * FROM canteenapplication.adminstandlogin where admin_username='" + s + "' && admin_password='" + s2 + "';";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(URL, user, pass);
                java.sql.Statement st = con.createStatement();
                ResultSet rs;
                rs = st.executeQuery(query);
                while (rs.next()) {
                        u = rs.getString(2);
                        p = rs.getString(3);
                        System.out.println(u + "::" + p);
                }

               if(s.isEmpty() && s2.isEmpty()){
                        Notifications failed = Notifications.create();
                        failed.title("LOGIN FAILED ");
                        failed.text("Incorrect username or password ..............");
                        failed.hideAfter(Duration.seconds(2));
                        failed.darkStyle();
                        failed.position(Pos.CENTER);
                        failed.showError();
               }
               else if (u.equals(s) && p.equals(s2)) {
                        Notifications success = Notifications.create();
                        success.title("LOGIN SUCCESSFULL ");
                        success.text("Admin Login Successfull ..................");
                        success.hideAfter(Duration.seconds(2));
                        success.darkStyle();
                        success.position(Pos.CENTER);
                        success.showInformation();
                        
                        AnchorPane FoodAdd = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
		adminloginscreen.getChildren().setAll(FoodAdd);
                }
                else{
                          Notifications failed = Notifications.create();
                        failed.title("LOGIN FAILED ");
                        failed.text("Incorrect username or password ..............");
                        failed.hideAfter(Duration.seconds(2));
                        failed.darkStyle();
                        failed.position(Pos.CENTER);
                        failed.showError();
                }
                 st.close();
                con.close();
        }

        @FXML
        private void adminCreateNewAdmin(ActionEvent event) throws IOException {

                Stage primaryStage = new Stage();
                AnchorPane createnewadmin = FXMLLoader.load(getClass().getResource("CreateNewAdmin.fxml"));
                Scene scene = new Scene(createnewadmin);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();

        }
        TakeNewOrderController tnoc=new TakeNewOrderController();
        @FXML
        private void staffLogin(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
                  String u="";
               String p="";
                String s = staff_username1.getText();
                String s2 = staff_password1.getText();
              
                String URL = "jdbc:mysql://localhost:3306/canteenapplication?autoReconnect=true&useSSL=false";
                String pass = "ActiveJarvis20";
                String user = "FunctionJarvis20";
                String query = "SELECT * FROM canteenapplication.staffstandlogin where staff_username='" + s + "' && staff_password='" + s2 + "';";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(URL, user, pass);
                java.sql.Statement st = con.createStatement();
                ResultSet rs;
                rs = st.executeQuery(query);
                while (rs.next()) {
                        u = rs.getString("staff_username");
                        p = rs.getString("staff_password");
                        System.out.println(u + "::" + p);
                          TakeNewOrderController.staffGet(u,p);
                }

               if(s.isEmpty() && s2.isEmpty()){
                        Notifications failed = Notifications.create();
                        failed.title("LOGIN FAILED ");
                        failed.text("Incorrect username or password ..............");
                        failed.hideAfter(Duration.seconds(2));
                        failed.darkStyle();
                        failed.position(Pos.CENTER);
                        failed.showError();
               }
               else if (u.equals(s) && p.equals(s2)) {
                        Notifications success = Notifications.create();
                        success.title("LOGIN SUCCESSFULL ");
                        success.text("Staff  Login Successfull ..................");
                        success.hideAfter(Duration.seconds(2));
                        success.darkStyle();
                        success.position(Pos.CENTER);
                        success.showInformation();
                      
                        AnchorPane FoodAdd = FXMLLoader.load(getClass().getResource("/canteenstand/staff/MainStaffUI.fxml"));
		adminloginscreen.getChildren().setAll(FoodAdd);
                     
                }
                else{
                          Notifications failed = Notifications.create();
                        failed.title("LOGIN FAILED ");
                        failed.text("Incorrect username or password ..............");
                        failed.hideAfter(Duration.seconds(2));
                        failed.darkStyle();
                        failed.position(Pos.CENTER);
                        failed.showError();
                }
          
                 st.close();
                con.close();
        }

}
