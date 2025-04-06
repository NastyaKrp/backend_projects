package org.example.factories;

import org.example.armchairs.Armchair;
import org.example.armchairs.VictorianArmchair;
import org.example.sofas.Sofa;
import org.example.sofas.VictorianSofa;
import org.example.tables.Table;
import org.example.tables.VictorianTable;

public class VictorianFactory implements Factory {

    @Override
    public Armchair createArmchair() {
        return new VictorianArmchair();
    }
    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}
