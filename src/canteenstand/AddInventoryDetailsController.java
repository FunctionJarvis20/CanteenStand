package canteenstand;

import canteenstand.database.Database;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


public class AddInventoryDetailsController implements Initializable {
           Database db=new Database();
        @FXML
        private AnchorPane inventorydetails;
        
    @FXML
    private JFXButton add_to_stock;

    @FXML
    private JFXTextField food_id;

    @FXML
    private JFXTextField food_name;

    @FXML
    private JFXTextField food_quantity;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

        @FXML
        private void foodInventoryInsertedInDatabase(ActionEvent event) throws SQLException {
           String foodid=food_id.getText();
           String foodname=food_name.getText();
           int  foodquantity=Integer.parseInt(food_quantity.getText());
           String query="select foodid from canteenapplication.inventorydetails";
           ResultSet rs=Database.st.executeQuery(query);
           while(rs.next())
           {
           if(foodid.equals(rs.getString(1)))
           {
             
                        Notifications success=Notifications.create();
                        success.title("Food Id Already exists ");
	    success.text("Please Enter New Food Id ...");
                        success.hideAfter(Duration.seconds(2));
                        success.darkStyle();
                        success.position(Pos.CENTER);
                        success.showError();
           }
           }
           if(Database.addInventory(foodid, foodname, foodquantity))
           {
                   
                        Notifications success=Notifications.create();
                        success.title("Inventory added succesfully ");
	    success.text("Inventory Added To the backend..");
                        success.hideAfter(Duration.seconds(2));
                        success.darkStyle();
                        success.position(Pos.CENTER);
                        success.showInformation();
                        
                         food_id.setText(null);
                        food_name.setText(null);
                        food_quantity.setText(null);
           }
           else{
                   
                        Notifications success=Notifications.create();
                        success.title("Inventory Unsuccessfull");
	    success.text("Failed To Add Inventory Details to the backend");
                        success.hideAfter(Duration.seconds(2));
                        success.darkStyle();
                        success.position(Pos.CENTER);
                        success.showError();
           }
        }

        @FXML
         void foodInventoryExit(ActionEvent event) throws IOException {
            
		AnchorPane FoodAdd = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
		inventorydetails.getChildren().setAll(FoodAdd);
             
        }
         @FXML
    void checkAvailableStock(ActionEvent event) throws IOException {
  Stage primaryStage = new Stage();
                AnchorPane availablestock = FXMLLoader.load(getClass().getResource("AvailableInventory.fxml"));
                Scene scene = new Scene(availablestock);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
    }

}
