package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private CheckBox isPolarCheckBox;

    @FXML
    private Label presentFormLabel;

    @FXML
    private ListView<String> numbersListView;

    private ObservableList<String> listViewData = FXCollections.observableArrayList();

    @FXML
    private TextField firstTextField;

    @FXML
    private TextField secondTextField;

    public Controller() {

    }

    @FXML
    private void initialize() {
        numbersListView.setItems(listViewData);


        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //Alert alert = new Alert(Alert.AlertType.ERROR);
                //alert.setTitle("");
                //alert.setHeaderText("");
                //alert.setContentText("");
                //alert.showAndWait();

                listViewData.add("Hello");
                //firstTextField.setText("Hello");
            }
        });
    }
}
