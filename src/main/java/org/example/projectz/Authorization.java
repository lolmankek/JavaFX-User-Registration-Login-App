package org.example.projectz;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import database.DataBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Authorization {

    @FXML
    private Button AuthorizationButton;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button RegistrationButton;

    private boolean validateUser(String firstName, String password) {
        String sql = "SELECT * FROM users WHERE first_name = ? AND password = ?";

        try (Connection conn = DataBase.connect();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, password);

            java.sql.ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    void initialize() {
        RegistrationButton.setOnAction(event -> {
            RegistrationButton.getScene().getWindow().hide();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Regestration.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Registration");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        AuthorizationButton.setOnAction(event -> {
            String login = LoginField.getText().trim();
            String password = PasswordField.getText().trim();

            if (validateUser(login, password)) {
                System.out.println("Успешный вход!");
                AuthorizationButton.getScene().getWindow().hide();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                    Parent root = loader.load();

                    Stage stage = new Stage();
                    stage.setTitle("Home Page");


                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Login or Password is not correct!");
            }
        });
    }
}
