package edu.lntu;

import javafx.scene.control.Alert;

public class AlertUtils {

    public static void showError(String message) {
        showMessage("Error", message, Alert.AlertType.ERROR);
    }

    public static void showWarning(String message) {
        showMessage("Warning", message, Alert.AlertType.WARNING);
    }

    public static void showInformation(String message) {
        showInformation("Information", message);
    }

    public static void showInformation(String title, String message) {
        showMessage(title, message, Alert.AlertType.INFORMATION);
    }

    private static void showMessage(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
