package org.example.app;

import org.example.armchairs.Armchair;
import org.example.sofas.Sofa;
import org.example.factories.Factory;
import org.example.tables.Table;

import java.util.Objects;

public class Application {
    private Sofa sofa;
    private Table table;
    private Armchair armchair;

    public Application(Factory factory) {
        sofa = factory.createSofa();
        table = factory.createTable();
        armchair = factory.createArmchair();
    }

    public void build() {
        sofa.build();
        table.build();
        armchair.build();
    }

    public void build(String info) {
        if (Objects.equals(info, "sofa"))
        {
            sofa.build();
        }
        if (Objects.equals(info, "table"))
        {
            table.build();
        }
        if (Objects.equals(info, "armchair"))
        {
            armchair.build();
        }
    }

    public void build(String info1, String info2) {
        if (Objects.equals(info1, "sofa"))
        {
            sofa.build();
        }
        if (Objects.equals(info1, "table"))
        {
            table.build();
        }
        if (Objects.equals(info1, "armchair"))
        {
            armchair.build();
        }
        if (Objects.equals(info2, "sofa"))
        {
            sofa.build();
        }
        if (Objects.equals(info2, "table"))
        {
            table.build();
        }
        if (Objects.equals(info2, "armchair"))
        {
            armchair.build();
        }
    }
}
