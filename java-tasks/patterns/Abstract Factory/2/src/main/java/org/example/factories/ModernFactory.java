package org.example.factories;

import org.example.armchairs.Armchair;
import org.example.armchairs.ModernArmchair;
import org.example.sofas.ModernSofa;
import org.example.sofas.Sofa;
import org.example.tables.ModernTable;
import org.example.tables.Table;

public class ModernFactory implements Factory {

    @Override
    public Armchair createArmchair() {
        return new ModernArmchair();
    }
    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}
