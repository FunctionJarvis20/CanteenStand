package canteenstand;

import canteenstand.database.Database;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class AddComboPacksController implements Initializable {

        int  c_id;
        String c_name;
        String f_category;
        String f_name;
        String a_food;
        double t_cost;
        
        @FXML
        private JFXTextField comboid;
        @FXML
        private JFXTextField comboname;
        @FXML
        private JFXComboBox<String> foodcategory;
        @FXML
        private JFXComboBox<String> foodname;
        @FXML
        private JFXComboBox<String> additionalfood;
        @FXML
        private JFXTextField totalcost;
        @FXML
        private JFXButton cancelbutton;
        @FXML
        private JFXButton addbutton;
        ObservableList<String> list1 = FXCollections.observableArrayList("starter", "maincourse", "desert");
        ObservableList<String> list2 = FXCollections.observableArrayList();
        ObservableList<String> list3 = FXCollections.observableArrayList();
        Database db = new Database();
 public static int randomIdGenerator() {
                Random randomfoodid = new Random();
                return randomfoodid.nextInt(10000);
        }
        @FXML
        private AnchorPane pane;
        @Override
        public void initialize(URL url, ResourceBundle rb) {
                try {
                       comboid.setText(Integer.toString( AddComboPacksController.randomIdGenerator()));
                        foodname.setDisable(true);
                        foodcategory.setItems(list1);
                        String query = "select food_item_name from canteenapplication.adminfooddetails";
                        ResultSet rs;
                        rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                list3.add(rs.getString("food_item_name"));
                        }
                        additionalfood.setItems(list3);
                } catch (SQLException ex) {
                        Logger.getLogger(AddComboPacksController.class.getName()).log(Level.SEVERE, null, ex);
                }

        }

        @FXML
        private void selectCategory(ActionEvent event) throws SQLException {
                String selected_category = foodcategory.getValue();
                if (selected_category.equals("starter")) {
                        foodname.getItems().clear();
                        foodname.setDisable(false);
                        String query = "select food_item_name from canteenapplication.adminfooddetails where food_item_category='starter'";
                        ResultSet rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                list2.add(rs.getString("food_item_name"));
                        }
                        foodname.setItems(list2);
                } else if (selected_category.equals("maincourse")) {
                        foodname.getItems().clear();
                        foodname.setDisable(false);
                        String query = "select food_item_name from canteenapplication.adminfooddetails where food_item_category='maincourse'";
                        ResultSet rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                list2.add(rs.getString("food_item_name"));
                        }
                        foodname.setItems(list2);

                } else {
                        foodname.getItems().clear();
                        foodname.setDisable(false);
                        String query = "select food_item_name from canteenapplication.adminfooddetails where food_item_category='desert'";
                        ResultSet rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                list2.add(rs.getString("food_item_name"));
                        }
                        foodname.setItems(list2);

                }
        }

        @FXML
        private void cancelCombo(ActionEvent event) throws IOException {
                AnchorPane MainUI=FXMLLoader.load(getClass().getResource("MainUI.fxml"));
                pane.getChildren().setAll(MainUI);
        }

        @FXML
        private void addCombo(ActionEvent event) throws SQLException, IOException {
                c_id=Integer.parseInt(comboid.getText());
                c_name=comboname.getText();
                f_category=foodcategory.getValue();
                f_name=foodname.getValue();
               a_food=additionalfood.getValue();
               t_cost=Double.parseDouble(totalcost.getText());
               String query="insert into canteenapplication.combooffers values (?,?,?,?,?,?);";
                PreparedStatement ps=Database.con.prepareStatement(query);
                ps.setInt(1,c_id);
                ps.setString(2,c_name);
                ps.setString(3,f_category);
                ps.setString(4,f_name);
                ps.setString(5,a_food);
                ps.setDouble(6,t_cost);
                int execute=ps.executeUpdate();
                  if (execute == 1) {
                                System.out.println("combo pack created perfectly ");
                                Notifications newfoodadded = Notifications.create();
                                newfoodadded.title("Combo Added ");
                                newfoodadded.text("Combo Succeesfull Added To The Backend");
                                newfoodadded.hideAfter(Duration.seconds(2));
                                newfoodadded.darkStyle();
                                newfoodadded.position(Pos.CENTER);
                                newfoodadded.showInformation();
                                 AnchorPane MainUI=FXMLLoader.load(getClass().getResource("AddComboPacks.fxml"));
                pane.getChildren().setAll(MainUI);

                        } else {
                                System.out.println("row Not Affected");
                        }
        }

}
