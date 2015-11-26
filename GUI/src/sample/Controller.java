package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import yegorov.math.Complex;

public class Controller {
    @FXML
    private RadioButton canonicalRadioButton;

    @FXML
    private RadioButton polarRadioButton;

    @FXML
    private RadioButton exponentRadioButton;

    @FXML
    private ToggleGroup group;

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private CheckBox isPolarFormCheckBox;

    @FXML
    private Label presentFormLabel;

    @FXML
    private Label selectedLabel;

    @FXML
    private ListView<String> numbersListView;

    private ObservableList<String> listViewData;

    @FXML
    private TextField firstTextField;

    @FXML
    private TextField secondTextField;

    private Alert alert;

    public Controller() {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Ошибка");
        alert.setContentText("Введите корректные значения");
    }

    @FXML
    private void initialize() {
        listViewData = numbersListView.getItems();
        checkPresentFormLabel();

        group = new ToggleGroup();
        canonicalRadioButton.setToggleGroup(group);
        polarRadioButton.setToggleGroup(group);
        exponentRadioButton.setToggleGroup(group);
        group.selectToggle(canonicalRadioButton);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(firstTextField.getText().isEmpty() || secondTextField.getText().isEmpty()) {
                    alert.showAndWait();
                    return;
                }

                double first = Double.parseDouble(firstTextField.getText());
                double second = Double.parseDouble(secondTextField.getText());

                Complex c;
                if (isPolarFormCheckBox.isSelected()) {
                    c = Complex.fromPolar(first, second);
                }
                else
                    c = Complex.fromCanonical(first, second);

                Toggle radio = group.getSelectedToggle();
                String represent = "";
                if(radio == canonicalRadioButton) {
                    represent = c.toCanonicalForm();
                } else if(radio == polarRadioButton) {
                    represent = c.toPolarForm(Complex.AngleUnit.DEGREE);
                } else if(radio == exponentRadioButton) {
                    represent = c.toExponentForm(Complex.AngleUnit.RADIAN);
                }

                listViewData.add(represent);
            }
        });

        clearButton.setOnAction(event -> {
            listViewData.clear();
        });

        isPolarFormCheckBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkPresentFormLabel();
            }
        });

        numbersListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    selectedLabel.setText(newValue);
                });

        firstTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(!firstTextField.getText().matches("[0-9]+(\\.[0-9]+)?")){
                    firstTextField.setText("");
                }
            }
        });

        secondTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                if(!secondTextField.getText().matches("[0-9]+(\\.[0-9]+)?")){
                    secondTextField.setText("");
                }
            }
        });
    }

    private void checkPresentFormLabel() {
        if (isPolarFormCheckBox.isSelected()) {
            presentFormLabel.setText("Тригонометрическая форма");
        }
        else {
            presentFormLabel.setText("Алгебраическая форма");
        }
    }
}
