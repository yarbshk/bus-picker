package edu.lntu;

import javafx.scene.control.Alert;

public class AlertUtils {

    public static void showPlainErrorAlert(String message) {
        showPlainAlert(message, "Error", Alert.AlertType.ERROR);
    }

    public static void showPlainWarningAlert(String message) {
        showPlainAlert(message, "Warning", Alert.AlertType.WARNING);
    }

    public static void showPlainInformationAlert(String message, String title) {
        showPlainAlert(message, title, Alert.AlertType.INFORMATION);
    }

    private static void showPlainAlert(String message, String title, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
