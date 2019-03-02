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
        int seatsNumber;
        try {
            seatsNumber = Integer.parseInt(this.seatsNumber.getText());
        } catch (NumberFormatException e) {
            showError("Provided value isn't a number");
            return;
        }

        List<Bus> buses;
        try {
            buses = busService.getBusesBySeatsNumber(seatsNumber);
        } catch (ParsingException e) {
            showWarning("Can't parse the input file");
            return;
        }

        if (buses.isEmpty()) {
            showWarning("No buses was found");
            return;
        }

        showInformation("Buses list", busService.stringifyBuses(buses));
    }
}
