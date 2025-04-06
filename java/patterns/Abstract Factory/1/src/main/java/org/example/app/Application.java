package org.example.app;

import org.example.buttons.Button;
import org.example.checkboxes.Checkbox;
import org.example.factories.GUIFactory;
import org.example.textfields.TextField;

public class Application {
    private Button button;
    private Checkbox checkbox;

    private TextField textField;

    public Application(GUIFactory factory) {
        textField = factory.createTextField();
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        textField.paint();
        button.paint();
        checkbox.paint();
    }
}
