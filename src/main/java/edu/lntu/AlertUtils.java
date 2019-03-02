package edu.lntu;

import javafx.scene.control.Alert;

public class AlertUtils {

    public static void showError(String message) {
        showMessage(message, "Error", Alert.AlertType.ERROR);
    }

    public static void showWarning(String message) {
        showMessage(message, "Warning", Alert.AlertType.WARNING);
    }

    public static void showInformation(String message, String title) {
        showMessage(message, title, Alert.AlertType.INFORMATION);
    }

    private static void showMessage(String message, String title, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
