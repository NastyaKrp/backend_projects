package org.example.factories;

import org.example.buttons.Button;
import org.example.buttons.WindowsButton;
import org.example.checkboxes.Checkbox;
import org.example.checkboxes.WindowsCheckbox;
import org.example.textfields.LinuxTextField;
import org.example.textfields.TextField;
import org.example.textfields.WindowsTextField;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}
