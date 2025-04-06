package org.example;

import org.example.builders.Director;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {

        Director director = new Director();
        Key key = Cr.Encr("input.json"); // для 2 и 4 случаев


        //Zip.Z("eninput.json", "eninput.zip"); // - для 4 случая с zip
        //Zip.Z("input.xml", "input.zip"); // - для 1 случая

        /*Zip.Z("input.xml", "input2.zip"); // для 3 случая с zip
        Key key2 = Cr.Encr("input2.zip"); // для 3 случая с zip*/


        /*List<String> k = new ArrayList<>();
        k.add("input.json");                      // для создания jar архива из файла input.json
        Jar.ArchJAR(k, "input.jar");   */         // для 3его и 1ого случая с jar архивом

        //Key key3 = Cr.Encr("input.jar"); // для 3его случая с jar архивом

        /*List<String> k = new ArrayList<>();
        k.add("eninput.json");                      // для создания jar архива из файла eninput.json
        Jar.ArchJAR(k, "eninput4.jar");*/

        //Примеры вызовов (учитывая, что изначально есть три файла input.txt, input.xml, input.json)
        //director.construct(key); //вызов 4ого случая c zip (json, json, eninput.json, 4, zip, eninput.zip)

        //director.construct(key);//вызов 0ого случая(txt, xml, input.txt, 0)

        //director.construct(key);//вызов 1ого случая c zip (xml, txt, input.xml, 1, zip, input.zip)

        //director.construct(key);//вызов 1ого случая c jar (json, xml, input.json, 1, jar, input.jar)

        //director.construct(key);//вызов 2ого случая(json, json, eninput.json, 2)

        //director.construct(key2);//вызов 3его случая c zip (xml, xml, input.xml, 3, zip, eninput2.zip)

        //director.construct(key3);//вызов 3его случая с jar архивом (json, json, input.json, 3, jar, eninput.jar)

        //director.construct(key); //вызов 4ого случая с jar (json, txt, eninput.json, 4, jar, eninput4.jar)
    }
}