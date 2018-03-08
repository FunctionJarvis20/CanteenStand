package canteenstand.staff;

import canteenstand.database.Database;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class TakeNewOrderController implements Initializable {

        @FXML
        private JFXTextField transactionid;
        @FXML
        private JFXDatePicker date;
        @FXML
        private JFXTimePicker time;
        @FXML
        private JFXRadioButton no;
        @FXML
        private ToggleGroup comboyesno;
        @FXML
        private JFXRadioButton yes;
        @FXML
        private JFXComboBox<String> combopack;
        @FXML
        private JFXComboBox<String> foodcategory;
        @FXML
        private JFXComboBox<String> foodname;
        @FXML
        private JFXTextField foodquantity;
        @FXML
        private JFXTextField totalamount;

        int t_id;
        String c_name;
        long c_phone;
        java.sql.Date d;
        java.sql.Time t;
        String co_pack;
        String f_category;
        String f_name;
        int f_quantity;
        Double t_amount;
        @FXML
        private JFXTextField customername;
        @FXML
        private JFXTextField customerphone;
        Database db = new Database();
        static String staffname;
        static String staffpass;
        int staffID;
  ObservableList<String> combopacks=FXCollections.observableArrayList();
  ObservableList<String> foodc=FXCollections.observableArrayList("starter","maincourse","desert");
  ObservableList<String> list2=FXCollections.observableArrayList();
  ObservableList<String> listviewfoodname=FXCollections.observableArrayList();
  ObservableList<Integer> listviewfoodquantity=FXCollections.observableArrayList();
    ObservableList<Integer> listviewfoodamount=FXCollections.observableArrayList();
    
  
        @FXML
        private JFXListView<String> allfood;
        @FXML
        private JFXListView<Integer> allquantity;
        @FXML
        private JFXListView<Integer> allamount;
       
        @Override
        public void initialize(URL url, ResourceBundle rb) {
                transactionid.setText(Integer.toString(TakeNewOrderController.randomIdGenerator()));
                foodcategory.setItems(foodc);
                LocalDate p = LocalDate.now();
                date.setValue(p);
                LocalTime t = LocalTime.now();
                time.setValue(t);
                String query = "select staff_id from canteenapplication.staffstandlogin where staff_username='" + TakeNewOrderController.staffname + "' && staff_password='" + TakeNewOrderController.staffpass + "'";
                ResultSet rs;
                try {
                        rs = Database.st.executeQuery(query);
                        while (rs.next()) {
                                staffID = rs.getInt("staff_id");
                        }
//                      TakeNewOrderController ta=new TakeNewOrderController();
//                      ta.comboPacksLoaded();
                      
        String query1="select combo_name from canteenapplication.combooffers ";
        ResultSet rs1=Database.st.executeQuery(query1);
        while(rs1.next())
        {
                combopacks.add(rs1.getString("combo_name"));
        }
        combopack.setItems(combopacks);
                } catch (Exception ex) {
                        Logger.getLogger(TakeNewOrderController.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
        public static void staffGet(String username, String password) {
                TakeNewOrderController.staffname = username;
                TakeNewOrderController.staffpass = password;

        }

        public static int randomIdGenerator() {
                Random randomfoodid = new Random();
                return randomfoodid.nextInt(100000);
        }

        @FXML
        private void addOrder(ActionEvent event) throws SQLException {

                if (yes.isSelected()) {
                        combopack.setDisable(false);
                        t_id = Integer.parseInt(transactionid.getText());
                        c_name = customername.getText();
                        c_phone = Long.parseLong(customerphone.getText());
                        d = java.sql.Date.valueOf(date.getValue());
                        t = java.sql.Time.valueOf(time.getValue());
                        co_pack = combopack.getValue();
                        f_category = foodcategory.getValue();
                        f_name = foodname.getValue();
                        f_quantity = Integer.parseInt(foodquantity.getText());
                        t_amount = Double.parseDouble(totalamount.getText());
                        String Query = "insert into canteenapplication.offlineorders values(?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = Database.con.prepareStatement(Query);
                        ps.setInt(1, staffID);
                        ps.setInt(2, t_id);
                        ps.setString(3, c_name);
                        ps.setLong(4, c_phone);
                        ps.setDate(5, d);
                        ps.setTime(6, t);
                        ps.setString(7, co_pack);
                        ps.setString(8, f_category);
                        ps.setString(9, f_name);
                        ps.setInt(10, f_quantity);
                        ps.setDouble(11, t_amount);
                        int execute = ps.executeUpdate();
                    
                        System.out.println("passed");
                        System.out.println(TakeNewOrderController.staffname + " :::::" + TakeNewOrderController.staffpass);
                        System.out.print(staffID);
                            if (execute == 1) {
                                System.out.println("values entered");
                        } else {
                                System.out.println("not entered");

                        }
                } else if (no.isSelected()) {
                        combopack.setDisable(true);

                } else {

                }
        }
//
//public void comboPacksLoaded() throws SQLException
//{
//}
        @FXML
        private void CancelOrder(ActionEvent event) {
        }

        @FXML
        private void addToList(ActionEvent event) throws SQLException {
                String foodall=foodname.getValue();
                int quantity=Integer.parseInt(foodquantity.getText());
                int amount=0;
                String category=foodcategory.getValue();
                String query="select food_item_amount from canteenapplication.adminfooddetails where food_item_category='"+category+"' && food_item_name='"+foodall+"'";
               ResultSet rs=Database.st.executeQuery(query);
               while(rs.next())
               {
                       amount=rs.getInt("food_item_amount");
                      
               }
               int finalamount=(quantity*amount);
                listviewfoodname.add(foodall);
                listviewfoodquantity.add(quantity);
                 listviewfoodamount.add(finalamount);
                allfood.setItems(listviewfoodname);
                allquantity.setItems(listviewfoodquantity);
                allamount.setItems(listviewfoodamount);
                
        }

        @FXML
        private void deleteItem(ActionEvent event) {
                String select=allfood.getSelectionModel().getSelectedItem();
                 int index=allfood.getSelectionModel().getSelectedIndex();
                if(select.isEmpty() && index==0)
                {
                        System.out.println("please Select the Items to delete");
                }
                else{
                
                allfood.getItems().remove(select);
                allquantity.getItems().remove(index);
                allamount.getItems().remove(index);
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
      

}
