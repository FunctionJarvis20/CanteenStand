/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteenstand;

import canteenstand.database.Database;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class RemoveFoodController implements Initializable {

        @FXML
        private JFXComboBox<String> foodcategory;
        @FXML
        private JFXComboBox<String> foodname;
        ObservableList<String> list1 = FXCollections.observableArrayList("starter", "maincourse", "desert");
        ObservableList<String> list2 = FXCollections.observableArrayList();
        ObservableList<String> list3 = FXCollections.observableArrayList("");
        Database db = new Database();

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                foodcategory.setItems(list1);

        }

        @FXML
        private void removeButton(ActionEvent event) throws ClassNotFoundException, SQLException {
                String foodCategory = foodcategory.getValue();
                String foodName = foodname.getValue();

                String URL = "jdbc:mysql://localhost:3306/canteenapplication?autoReconnect=true&useSSL=false";
                String pass = "ActiveJarvis20";
                String user = "FunctionJarvis20";
                String query2 = "select ";
                String query = "delete from adminfooddetails where food_item_category=? AND food_item_name=? ";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(URL, user, pass);
                PreparedStatement pt = con.prepareStatement(query);
                pt.setString(1, foodCategory);
                pt.setString(2, foodName);
                int execute = pt.executeUpdate();
                if (execute == 1) {
                        System.out.println("row deleted successfully");
                        Notifications newfoodadded = Notifications.create();
                        newfoodadded.title("Food Removed ");
                        newfoodadded.text("succeesfull Removed From the backend");
                        newfoodadded.hideAfter(Duration.seconds(2));
                        newfoodadded.darkStyle();
                        newfoodadded.position(Pos.CENTER);
                        newfoodadded.showInformation();
                } else {
                        System.out.print("not deleted");
                        Notifications newfoodadded = Notifications.create();
                        newfoodadded.title("Removed Failed ");
                        newfoodadded.text("Food Not Removed From Backend , Please Select The Food To Removed From Backend");
                        newfoodadded.hideAfter(Duration.seconds(2));
                        newfoodadded.darkStyle();
                        newfoodadded.position(Pos.CENTER);
                        newfoodadded.showError();
                }
                foodname.getItems().clear();
                foodcategory.getSelectionModel().clearSelection();

        }

        @FXML
        private void cancelButton(ActionEvent event) {
                ((Node) event.getSource()).getScene().getWindow().hide();
        }

        @FXML
        private void selectCategory(ActionEvent event) throws SQLException {
                String food_category = foodcategory.getValue();
                if (food_category.equals("starter")) {

                        foodname.getItems().clear();
                        String query = "select food_item_name from canteenapplication.adminfooddetails where food_item_category='starter'";
                        ResultSet rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                list2.add(rs.getString("food_item_name"));
                        }
                        foodname.setItems(list2);
                } else if (food_category.equals("maincourse")) {
                        foodname.getItems().clear();
                        String query = "select food_item_name from canteenapplication.adminfooddetails where food_item_category='maincourse'";
                        ResultSet rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                list2.add(rs.getString("food_item_name"));
                        }
                        foodname.setItems(list2);
                } else {
                        foodname.getItems().clear();
                        String query = "select food_item_name from canteenapplication.adminfooddetails where food_item_category='desert'";
                        ResultSet rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                list2.add(rs.getString("food_item_name"));
                        }
                        foodname.setItems(list2);
                }
        }

}
