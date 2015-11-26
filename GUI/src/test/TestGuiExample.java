import javafx.scene.Parent;
import javafx.scene.control.Button;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.categories.TestFX;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;

@Category(TestFX.class)
public class TestGuiExample extends GuiTest {
    @Override
    protected Parent getRootNode() {
        final Button btn = new Button();
        btn.setId("btn");
        btn.setText("Hello World");
        btn.setOnAction((actionEvent)-> btn.setText( "was clicked" ));
        return btn;
    }

    @Test
    public void shouldClickButton(){
        final Button button = find( "#btn" );
        click(button);
        verifyThat("#btn", hasText("was clicked"));
    }

    //@Test
    public void testMyUser() {
        final Button button = find("#addButton");
        click(button);
        //verifyThat("#addButton", hasText("was clicked"));
        final StringBuilder id = new StringBuilder();
        findAll(".button").forEach(node -> {
            id.append(node.getId() + " ");
        });
        org.junit.Assert.assertEquals(id.toString(), "");


        click(".button");
    }
}