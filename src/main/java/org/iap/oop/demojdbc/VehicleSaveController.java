package org.iap.oop.demojdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleSaveController {

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtGears;

    @FXML
    private TextField txtModel;

    @FXML
    private TextField txtPrice;

    @FXML
    void btnCancal(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void btnSave(ActionEvent actionEvent) {
        String brand = txtBrand.getText();
        String model = txtModel.getText();
        int gears = Integer.parseInt(txtGears.getText());
        double price = Double.parseDouble(txtPrice.getText());

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "Vimu@2164");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into vehicles (brand, model, no_of_gears, price) values (?, ?, ?,? )");

            preparedStatement.setObject(1, brand);
            preparedStatement.setObject(2, model);
            preparedStatement.setObject(3, gears);
            preparedStatement.setObject(4, price);

            boolean isok = preparedStatement.executeUpdate()>0;

            if (isok){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Save Successful!");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Save Failed!");
                alert.showAndWait();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
