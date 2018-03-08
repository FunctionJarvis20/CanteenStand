
package canteenstand.staff;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainStaffUIController implements Initializable {

        @FXML
        private AnchorPane customerAdd;

        @Override
        public void initialize(URL url, ResourceBundle rb) {
            
        }        
        @FXML
        private void takeNewOrder(ActionEvent event) throws IOException {
                
                  Stage primaryStage = new Stage();
                AnchorPane removefood = FXMLLoader.load(getClass().getResource("TakeNewOrder.fxml"));
                Scene scene = new Scene(removefood);
                //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
        }

        
}
