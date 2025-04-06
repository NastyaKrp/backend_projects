package org.example.factories;

import org.example.buttons.Button;
import org.example.buttons.MacOSButton;
import org.example.checkboxes.Checkbox;
import org.example.checkboxes.MacOSCheckbox;
import org.example.textfields.LinuxTextField;
import org.example.textfields.MacOSTextField;
import org.example.textfields.TextField;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new MacOSTextField();
    }
}
