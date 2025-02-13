package org.iap.oop.demojdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleDeleteController {

    @FXML
    private TextField txtId;

    @FXML
    void cancalBtn(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void deleteBtn(ActionEvent event) {
        try {

            int id = Integer.parseInt(txtId.getText());

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "Vimu@2164");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vehicles WHERE id = ?");

            preparedStatement.setObject(1, id);

            boolean isok = preparedStatement.executeUpdate()>0;

            if (isok){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Delete Successful!");
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Delete Failed!");
                alert.showAndWait();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
