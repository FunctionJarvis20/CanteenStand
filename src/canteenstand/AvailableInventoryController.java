/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteenstand;

import canteenstand.database.Database;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AvailableInventoryController implements Initializable {
ObservableList<Inventory> list=FXCollections.observableArrayList();
        @FXML
        private AnchorPane AvailableInventory;
        @FXML
        private TableView<Inventory> inventory_table;
        @FXML
        private TableColumn<Inventory, String> foodid_col;
        @FXML
        private TableColumn<Inventory, String> foodname_col;
        @FXML
        private TableColumn<Inventory, Integer> foodquantity_col;

        /**
         * Initializes the controller class.
         */
        @Override
        public void initialize(URL url, ResourceBundle rb) {
             initColoumn();
        try {
                loadData();
        } catch (SQLException ex) {
                Logger.getLogger(AvailableInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }        

        private void initColoumn() {
              foodid_col.setCellValueFactory(new PropertyValueFactory<>("foodid"));
              foodname_col.setCellValueFactory(new PropertyValueFactory<>("foodname"));
              foodquantity_col.setCellValueFactory(new PropertyValueFactory<>("foodquantity"));
        }

        private void loadData() throws SQLException {
        Database db=new Database();
        String query="select * from canteenapplication.inventorydetails";
        ResultSet rs=Database.st.executeQuery(query);
        while(rs.next())
        {
                String food_id=rs.getString(1);
                String food_name=rs.getString(2);
                int food_quantity=rs.getInt(3);
                    list.add(new Inventory(food_id,food_name,food_quantity));
        }
    inventory_table.getItems().setAll(list);
        }
        
       public static class Inventory
        {
                private final SimpleStringProperty foodid;
                private final SimpleStringProperty foodname;
                private final SimpleIntegerProperty foodquantity;
                
                Inventory(String foodid,String foodname,int foodquantity)
                {
                        this.foodid=new SimpleStringProperty(foodid);
                        this.foodname=new SimpleStringProperty(foodname);
                        this.foodquantity=new SimpleIntegerProperty(foodquantity);
                        
                        
                        
                }

                public String getFoodid() {
                        return foodid.get();
                }

                public String getFoodname() {
                        return foodname.get();
                }

                public int getFoodquantity() {
                        return foodquantity.get();
                }
                
        }
        
        
        
}
