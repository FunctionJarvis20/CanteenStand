package canteenstand;

import canteenstand.database.Database;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class UpdateInventoryDetailsController implements Initializable {

        String getProduct;
        @FXML
        private JFXComboBox<String> productname;
        @FXML
        private JFXTextField availablequantity;
        @FXML
        private JFXTextField newquantity;
        ObservableList<String> list1 = FXCollections.observableArrayList();
        Database db = new Database();
        @FXML
        private JFXButton update;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                  update.setDisable(true);
                String query = "select foodname from canteenapplication.inventorydetails";
                ResultSet rs;
                try {
                        rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                list1.add(rs.getString("foodname"));
                        }
                        productname.setItems(list1);
                } catch (SQLException ex) {
                        Logger.getLogger(UpdateInventoryDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }

        }

        @FXML
        private void selectProductName(ActionEvent event) throws SQLException {
                getProduct = productname.getValue();
                if(getProduct.isEmpty())
                {
                        System.out.println("please select Product");
                      
                }
                else
                {
                        update.setDisable(false);
                }
                String query = "select foodquantity from canteenapplication.inventorydetails where foodname='" + getProduct + "'";
                ResultSet rs = Database.st.executeQuery(query);
                while (rs.next()) {
                        availablequantity.setText(rs.getString("foodquantity"));
                }
        }

        @FXML
        private void cancelButton(ActionEvent event) {
                 ((Node) event.getSource()).getScene().getWindow().hide();
        }

        @FXML
        private void updateButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
                
                String new_quantity = newquantity.getText();
                if(new_quantity.isEmpty())
                {
                        System.out.println("please enter some quantity");
                        Notifications newfoodadded = Notifications.create();
                        newfoodadded.title("Product Updation Failed ");
                        newfoodadded.text("Please Select the Product And Enter the Quantity");
                        newfoodadded.hideAfter(Duration.seconds(2));
                        newfoodadded.darkStyle();
                        newfoodadded.position(Pos.CENTER);
                        newfoodadded.showError();
                }
                else
                {
                String URL = "jdbc:mysql://localhost:3306/canteenapplication?autoReconnect=true&useSSL=false";
                String pass = "ActiveJarvis20";
                String user = "FunctionJarvis20";
                String query2 = "select ";
                String query = "update canteenapplication.inventorydetails set foodquantity= ? where foodname=?";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(URL, user, pass);
                PreparedStatement pt = con.prepareStatement(query);
                pt.setString(1, new_quantity);
                pt.setString(2, getProduct);
                int execute = pt.executeUpdate();
                if(execute==1)
                {
                        System.out.println("food quantity updated");
                        Notifications newfoodadded = Notifications.create();
                        newfoodadded.title("Product Updated  ");
                        newfoodadded.text("Succeesfull Updated To the backend");
                        newfoodadded.hideAfter(Duration.seconds(2));
                        newfoodadded.darkStyle();
                        newfoodadded.position(Pos.CENTER);
                        newfoodadded.showInformation();
                        
                }
                else
                {
                        System.out.println("food quantity updated failed");
                        Notifications newfoodadded = Notifications.create();
                        newfoodadded.title("Product Updation Failed ");
                        newfoodadded.text("Product Not Update To Backend , Please Select The Product  To Update From Backend And Enter quantity");
                        newfoodadded.hideAfter(Duration.seconds(2));
                        newfoodadded.darkStyle();
                        newfoodadded.position(Pos.CENTER);
                        newfoodadded.showError();
                }
                availablequantity.clear();
                newquantity.clear();
                productname.getSelectionModel().clearSelection();
                  ((Node) event.getSource()).getScene().getWindow().hide();
                MainUIController m=new MainUIController();
                m.updateAgain();
        }
        }

}
