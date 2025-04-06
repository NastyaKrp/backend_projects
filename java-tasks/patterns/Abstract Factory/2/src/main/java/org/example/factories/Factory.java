package org.example.factories;

import org.example.sofas.Sofa;
import org.example.tables.Table;
import org.example.armchairs.Armchair;

public interface Factory {
    Sofa createSofa();
    Table createTable();
    Armchair createArmchair();
}