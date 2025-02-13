package org.iap.oop.demojdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class VehicleUpdateController {


    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtGears;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    void btnCancal(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int gears = Integer.parseInt(txtGears.getText());
        double price = Double.parseDouble(txtPrice.getText());

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "Vimu@2164");
            PreparedStatement preparedStatement = connection.prepareStatement("update vehicles set brand = ? , model = ? , no_of_gears = ?, price = ? where id = ? ");

            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, gears);
            preparedStatement.setObject(4, price);
            preparedStatement.setObject(5, id);

            boolean isok = preparedStatement.executeUpdate()>0;

            if (isok){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Update Successful!");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Update Failed!");
                alert.showAndWait();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void SearchBtn(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "Vimu@2164");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles where id = ? ");

            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                txtBrand.setText(resultSet.getString("brand"));
                txtModel.setText(resultSet.getString("model"));
                txtGears.setText(String.valueOf(resultSet.getInt("no_of_gears")));
                txtPrice.setText(String.valueOf(resultSet.getDouble("price")));
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
