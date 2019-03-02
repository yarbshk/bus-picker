package edu.lntu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Setter;

import java.util.List;

import static edu.lntu.AlertUtils.*;

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
            showError("Provided value isn't a number");
            return;
        }

        // Filter buses by the seats number
        List<Bus> buses;
        try {
            buses = busService.getBusesBySeatsNumber(seatsNumber);
        } catch (ParsingException e) {
            showWarning("Can't parse the input file");
            return;
        }

        // Check for emptiness of the buses list
        if (buses.isEmpty()) {
            showWarning("No buses was found");
            return;
        }

        showInformation(busService.collectBusNames(buses), "Buses");
    }
}
