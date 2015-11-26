import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.categories.TestFX;
import sample.Main;

import java.io.IOException;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;

public class GUIComplexTest extends GuiTest {
    @Override
    protected Parent getRootNode() {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("main.fxml"));
            return root;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    1.	Проверить, что при выбранном состоянии элемент управления isPolarFormCheckBox
        изменяет содержимое элемента управления presentFormLabel.
     */
    @Test
    public void testClickOnPolarFormCheckBox() {
        CheckBox isPolarCheckbox = find("#isPolarFormCheckBox");
        Label label = find("#presentFormLabel");

        Assert.assertEquals("Алгебраическая форма", label.getText());
        sleep(1500);
        click(isPolarCheckbox);
        sleep(1500);
        Assert.assertEquals("Тригонометрическая форма", label.getText());
        sleep(1500);
        click(isPolarCheckbox);
        Assert.assertEquals("Алгебраическая форма", label.getText());
        sleep(2500);
    }

    /*
    2.	Проверить, что при вводе чисел в элементы управления
        firstTextField и secondTextField, последующее нажатие на кнопку addButton,
        добавляет строковое значение комплексного числа в элемент управления numbersListView.
     */
    @Test
    public void testClickOnAddButton() {
        Button addbutton = find("#addButton");
        TextField firstTextField = find("#firstTextField");
        TextField secondTextField = find("#secondTextField");
        ListView<String> numbersListView = find("#numbersListView");

        Assert.assertEquals(0, numbersListView.getItems().size());

        move(firstTextField).click(firstTextField)
                .type("10.5")
                .sleep(1500)
        .move(secondTextField).click(secondTextField)
                .type("5")
                .sleep(1500)
        .move(addbutton).sleep(1000).click(addbutton);

        Assert.assertEquals(1, numbersListView.getItems().size());

        firstTextField.setText("");
        secondTextField.setText("");
        move(firstTextField).click(firstTextField)
                .type("20.11091")
                .sleep(1500)
                .move(secondTextField).click(secondTextField)
                .type("0.1234567")
                .sleep(1500)
                .move(addbutton).sleep(1000).click(addbutton);

        Assert.assertEquals(2, numbersListView.getItems().size());
    }

    /*
    3.	Проверить, что при нажатии на элемент списка numbersListView,
        изменяется значение элемента управления selectedLabel.
     */
    @Test
    public void testClickOnListViewItem() {
        ListView<String> numbersListView = find("#numbersListView");
        Label label = find("#selectedLabel");
        numbersListView.getItems().addAll("Значение списка 1",
                "Значение списка 2",
                "Значение списка 3",
                "Значение списка 4",
                "Значение списка 5",
                "Значение списка 6",
                "Значение списка 7",
                "Значение списка 8");

        move(numbersListView);

        click(MouseButton.PRIMARY);

        Assert.assertEquals(numbersListView.getSelectionModel().getSelectedItems().get(0), label.getText());

        sleep(1500);
    }

    /*
    4.	Проверить, что при нажатии на кнопку clearButton,
        данные в numbersListView удаляются.
     */
    @Test
    public void testClickOnClearButton() {
        Button clearButton = find("#clearButton");
        ListView<String> numbersListView = find("#numbersListView");
        numbersListView.getItems().addAll("Значение списка 1",
                "Значение списка 2",
                "Значение списка 3",
                "Значение списка 4",
                "Значение списка 5",
                "Значение списка 6",
                "Значение списка 7",
                "Значение списка 8");

        Assert.assertEquals(8, numbersListView.getItems().size());

        move(clearButton).sleep(1500).click(clearButton);

        Assert.assertEquals(0, numbersListView.getItems().size());
    }

    /*
    5.	Проверить, что при выборе polarRadioButton, строковые значения
        комплексного числа заносятся в тригонометрической форме.
     */
    @Test
    public void testPolarRadioButtonAddToListView() {
        Button addbutton = find("#addButton");
        TextField firstTextField = find("#firstTextField");
        TextField secondTextField = find("#secondTextField");
        ListView<String> numbersListView = find("#numbersListView");

        RadioButton polarRadioButton = find("#polarRadioButton");
        RadioButton exponentRadioButton = find("#exponentRadioButton");

        move(firstTextField).click(firstTextField)
                .type("10.5")
                .sleep(1500)
                .move(secondTextField).click(secondTextField)
                .type("5")
                .sleep(1500)
                .move(exponentRadioButton)
                .sleep(1500)
                .click(exponentRadioButton)
                .move(addbutton).sleep(1000).click(addbutton);

        Assert.assertFalse(numbersListView.getItems().get(0).contains("sin"));

        firstTextField.setText("");
        secondTextField.setText("");
        move(firstTextField).click(firstTextField)
                .type("10.1234")
                .sleep(1500)
                .move(secondTextField).click(secondTextField)
                .type("5.9832")
                .sleep(1500)
                .move(polarRadioButton)
                .sleep(1500)
                .click(polarRadioButton)
                .move(addbutton).sleep(1000).click(addbutton);

        Assert.assertTrue(numbersListView.getItems().get(1).contains("sin"));
        Assert.assertTrue(numbersListView.getItems().get(1).contains("cos"));
    }

}
