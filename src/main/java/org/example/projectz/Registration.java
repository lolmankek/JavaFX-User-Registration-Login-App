package org.example.projectz;

import database.DataBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Registration {

    @FXML
    private PasswordField ConfirmPassword;

    @FXML
    private PasswordField EnterPassword;

    @FXML
    private CheckBox Female_Checkbox;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField LastName;

    @FXML
    private CheckBox Male_Checkbox;

    @FXML
    private Button RegistrationButton;

    /**
     * Function that checks person is Male or Female
     */
    @FXML
    public void initialize() {
        Male_Checkbox.setOnAction(event -> {
            if (Male_Checkbox.isSelected()) {
                Female_Checkbox.setSelected(false);
            }
        });

        Female_Checkbox.setOnAction(event -> {
            if (Female_Checkbox.isSelected()) {
                Male_Checkbox.setSelected(false);
            }
        });
    }

    @FXML
    void Registration() {

        RegistrationButton.setOnAction(event -> {
            String firstName = FirstName.getText().trim();
            String lastName = LastName.getText().trim();
            String password = EnterPassword.getText().trim();
            String confirmpassword = ConfirmPassword.getText().trim();
            String sex = Male_Checkbox.isSelected() ? "Male" : (Female_Checkbox.isSelected() ? "Female" : "Why Are You, A ZEBRA?");


            //I'm too lazy, so I combined all the fields into one error
            if (firstName.equals("") || lastName.equals("")|| password.equals("") || ConfirmPassword.equals("") || (!Male_Checkbox.isSelected() || !Female_Checkbox.isSelected()) ){
                System.out.println("The field is empty");
                return;
            }

            //check if Password == ConfirmPassword
            if (!password.equals(confirmpassword)) {
                System.out.println("The passwords do not match!");
                return;
            }


            saveUserToDB(firstName, lastName, password, sex);

            openAuthorizationWindow();
            //Hide the Registration window after all
            Stage currentStage = (Stage) RegistrationButton.getScene().getWindow();
            currentStage.hide();
        });
    }

    private void saveUserToDB(String firstName, String lastName, String password, String sex) {
        String sql = "INSERT INTO users (first_name, last_name, password, sex) VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBase.connect();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, password);
            pstmt.setString(4, sex);
            pstmt.executeUpdate();

            System.out.println("User has successfully registered");

        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    private void openAuthorizationWindow() {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("Authorization.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Authorization");
            stage.setScene(new javafx.scene.Scene(root, 286, 215));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}