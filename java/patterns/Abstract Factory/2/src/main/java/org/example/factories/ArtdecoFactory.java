package org.example.factories;

import org.example.armchairs.Armchair;
import org.example.armchairs.ArtdecoArmchair;
import org.example.sofas.ArtdecoSofa;
import org.example.sofas.Sofa;
import org.example.tables.ArtdecoTable;
import org.example.tables.Table;

public class ArtdecoFactory implements Factory {

    @Override
    public Armchair createArmchair() {
        return new ArtdecoArmchair();
    }
    @Override
    public Sofa createSofa() {
        return new ArtdecoSofa();
    }

    @Override
    public Table createTable() {
        return new ArtdecoTable();
    }
}
