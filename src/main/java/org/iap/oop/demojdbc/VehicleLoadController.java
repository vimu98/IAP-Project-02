package org.iap.oop.demojdbc;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
import java.util.ArrayList;

public class VehicleLoadController {

    @FXML
    private TableView<Vehicle> tblVehicle;

    public void initialize() {
        tblVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("model"));
        tblVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gears"));
        tblVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));

        ArrayList<Vehicle> vehicles = loadData();
        tblVehicle.setItems(FXCollections.observableArrayList(vehicles));
    }

    public ArrayList<Vehicle> loadData(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iap_2", "root", "Vimu@2164");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicles");


            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList <Vehicle> list = new ArrayList<>();

            while (resultSet.next()){
               list.add(new Vehicle(
                       resultSet.getInt("id"),
                       resultSet.getString("brand"),
                       resultSet.getString("model"),
                       resultSet.getInt("no_of_gears"),
                       resultSet.getDouble("price")));
            }

            return list;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
