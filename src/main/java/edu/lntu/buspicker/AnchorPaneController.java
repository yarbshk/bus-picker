package edu.lntu.buspicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Setter;

import java.util.List;

@Setter(onMethod_ = {@FXML})
public class AnchorPaneController {

    public TextField seatsNumber;
    public Button searchButton;

    @Setter
    private BusService busService = new BusService();

    public void searchSuitableBuses(ActionEvent actionEvent) {
        // Verify that provided number of seats is a number
        int seatsNumber;
        try {
            seatsNumber = Integer.parseInt(this.seatsNumber.getText());
        } catch (NumberFormatException e) {
            AlertUtils.showPlainErrorAlert("Provided value isn't a number");
            return;
        }

        // Filter buses by the seats number
        List<Bus> buses;
        try {
            buses = busService.getBusesBySeatsNumber(seatsNumber);
        } catch (ParsingException e) {
            AlertUtils.showPlainWarningAlert("Can't parse the input file");
            return;
        } catch (IllegalArgumentException e) {
            AlertUtils.showPlainErrorAlert(e.getMessage());
            return;
        }

        // Check for emptiness of the buses list
        if (buses.isEmpty()) {
            AlertUtils.showPlainWarningAlert("No buses was found");
            return;
        }

        AlertUtils.showPlainInformationAlert(busService.collectBusNames(buses), "Buses");
    }
}
