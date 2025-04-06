package org.example.factories;

import org.example.buttons.Button;
import org.example.checkboxes.Checkbox;
import org.example.textfields.TextField;

public interface GUIFactory {
    TextField createTextField();
    Button createButton();
    Checkbox createCheckbox();
}