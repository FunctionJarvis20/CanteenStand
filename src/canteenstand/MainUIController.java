package canteenstand;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainUIController implements Initializable {

        @FXML
        AnchorPane FoodAdd;

        @Override
        public void initialize(URL url, ResourceBundle rb) {

        }

        @FXML
        public void AddNewFood(ActionEvent e) throws IOException {
                AnchorPane pane2 = FXMLLoader.load(getClass().getResource("AddNewFoodScreen.fxml"));
                FoodAdd.getChildren().setAll(pane2);
        }

        @FXML
        private void addInventoryDetails(ActionEvent event) throws IOException {
                AnchorPane inventorydetails = FXMLLoader.load(getClass().getResource("AddInventoryDetails.fxml"));
                FoodAdd.getChildren().setAll(inventorydetails);
        }

        @FXML
        private void logout(ActionEvent event) throws IOException {
                ((Node) event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                AnchorPane createnewadmin = FXMLLoader.load(getClass().getResource("StartApplication.fxml"));
                Scene scene = new Scene(createnewadmin);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();

        }

        @FXML
        private void addComboOffers(ActionEvent event) throws Exception {
   AnchorPane pane2 = FXMLLoader.load(getClass().getResource("AddComboPacks.fxml"));
                FoodAdd.getChildren().setAll(pane2);
        }

        @FXML
        private void removeFood(ActionEvent event) throws IOException {
                
                Stage primaryStage = new Stage();
                AnchorPane removefood = FXMLLoader.load(getClass().getResource("RemoveFood.fxml"));
                Scene scene = new Scene(removefood);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
        }

        @FXML
        private void updateInventory(ActionEvent event) throws IOException {
                    Stage primaryStage = new Stage();
                AnchorPane removefood = FXMLLoader.load(getClass().getResource("UpdateInventoryDetails.fxml"));
                Scene scene = new Scene(removefood);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
        }
        public void updateAgain() throws IOException
        {
                  Stage primaryStage = new Stage();
                AnchorPane removefood = FXMLLoader.load(getClass().getResource("UpdateInventoryDetails.fxml"));
                Scene scene = new Scene(removefood);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
        }

        
}
