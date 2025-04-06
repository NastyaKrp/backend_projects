package org.example;

import org.example.app.Application;
import org.example.factories.GUIFactory;
import org.example.factories.LinuxFactory;
import org.example.factories.MacOSFactory;
import org.example.factories.WindowsFactory;

public class Main {
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        //osName = "linux";
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        }
        else if(osName.contains("windows")){
            factory = new WindowsFactory();
        }
        else {
            factory = new LinuxFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}