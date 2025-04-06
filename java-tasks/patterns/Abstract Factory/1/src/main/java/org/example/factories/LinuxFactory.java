package org.example.factories;

import org.example.buttons.Button;
import org.example.buttons.LinuxButton;
import org.example.checkboxes.Checkbox;
import org.example.checkboxes.LinuxCheckbox;
import org.example.textfields.LinuxTextField;
import org.example.textfields.TextField;

public class LinuxFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LinuxCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
}
