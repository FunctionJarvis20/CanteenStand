package canteenstand;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AddNewFoodController implements Initializable {

	@FXML
	private AnchorPane pane2;

	@FXML
	private JFXTextField f_item_no;

	@FXML
	private JFXTextField f_category;

	@FXML
	private JFXTextField f_item_name;

	@FXML
	private JFXTextField f_item_amount;

	@FXML
	private JFXTextField r_product_id;

	@FXML
	private JFXTextField r_product_quantity;

	@FXML
	private JFXTextField r_product_name;
	
	int food_item_no;
	String food_category;
	String food_item_name;
	int	food_item_amount;
	String required_product_id;
	String required_product_quantity;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}

	@FXML
	    void foodInsertedInDatabase(ActionEvent event) {
		try {
			food_item_no=Integer.parseInt(f_item_no.getText());
			food_category=f_category.getText();
			food_item_name=f_item_name.getText();
			food_item_amount=Integer.parseInt(f_item_amount.getText());
			required_product_id=r_product_id.getText();
			required_product_quantity=r_product_quantity.getText();
			
			String URL="jdbc:mysql://localhost:3306/canteenapplication?autoReconnect=true&useSSL=false";
			String pass="ActiveJarvis20";
			String user="FunctionJarvis20";
			String query="insert into adminfooddetails values (?,?,?,?,?,?);";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL,user,pass);
			PreparedStatement pt=con.prepareStatement(query);
			pt.setInt(1, food_item_no);
			pt.setString(2, food_category);
			pt.setString(3, food_item_name);
			pt.setInt(4, food_item_amount);
			pt.setString(5, required_product_id);
			pt.setString(6, required_product_quantity);
			int execute=pt.executeUpdate();
			if(execute==1)
			{
			System.out.println("row Inserted Perfectly");	
			Notifications newfoodadded=Notifications.create();
			newfoodadded.title("Food Added ");
			newfoodadded.text("succeesfull added to the backend");
			newfoodadded.hideAfter(Duration.seconds(2));
			newfoodadded.darkStyle();
			newfoodadded.position(Pos.CENTER);
			newfoodadded.showInformation();
			
			f_item_no.setText(" ");
			f_category.setText(" ");
			f_item_name.setText(" ");
			f_item_amount.setText(" ");
			r_product_id.setText(" ");
			r_product_quantity.setText(" ");
			}
			else
			{
				System.out.println("row Not Affected");
			}
		} catch (Exception e) {
			Notifications exp=Notifications.create();
			exp.title("Warning :: Food Not Added ");
			exp.text("Food has a duplicate ID, please enter the new ID");
			exp.hideAfter(Duration.seconds(2));
			exp.darkStyle();
			exp.position(Pos.CENTER);
			exp.showWarning();
		}
	  }

	@FXML
	public void MainUI(ActionEvent event) throws IOException {

		AnchorPane FoodAdd = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
		pane2.getChildren().setAll(FoodAdd);

	}

}
