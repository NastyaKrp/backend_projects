package com.example.fib.builders;


import com.example.fib.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DirectorRest {

    public String input_path;

    public String archPath;

    public String archType;

    public String archTypeOut;
    public String out_type;
    public String in_type;

    public Integer in;

    public Integer out;

    public void construct(Key key) throws Exception {
        DirectorRest director = new DirectorRest();

        switch(in)
        {
            case 0:
                director.construct0(in_type, out_type, input_path, out);
                break;
            case 1:
                director.construct1(in_type, out_type, input_path, out);
                break;
            case 2:
                director.construct2(in_type, out_type, key, input_path, out);
                break;
            case 3:
                director.construct3(in_type, out_type, key, input_path, out);
                break;
            case 4:
                director.construct4(in_type, out_type, key, input_path, out);
                break;
        }
    }

    public void construct0(String in, String out, String path_in, Integer out_type) throws Exception {
        List<String> info = new ArrayList<>();
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT(path_in);
                break;
            case "xml":
                info = XML.ReadXML(path_in);
                break;
            case "json":
                info = JSON.ReadJSON(path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out_type)
        {
            case 0:
                out_res(info, out);
                break;
            case 1:
                out_res1(info, out);
                break;
            case 2:
                out_res2(info, out);
                break;
            case 3:
                out_res3(info, out);
                break;
            case 4:
                out_res4(info, out);
                break;
        }
    }

    public void construct1(String in, String out, String path_in, Integer out_type) throws Exception {
        String type = archType;
        String zName = archPath;
        List<String> info = new ArrayList<>();
        String add = "new";
        if(Objects.equals(type, "zip"))
        {
            Zip.Arch(zName);
        }
        else
        {
            add = "j" + add;
            Jar.exJAR(zName);
        }
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT(add + path_in);
                break;
            case "xml":
                info = XML.ReadXML(add + path_in);
                break;
            case "json":
                info = JSON.ReadJSON(add + path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out_type)
        {
            case 0:
                out_res(info, out);
                break;
            case 1:
                out_res1(info, out);
                break;
            case 2:
                out_res2(info, out);
                break;
            case 3:
                out_res3(info, out);
                break;
            case 4:
                out_res4(info, out);
                break;
        }
    }

    public void construct2(String in, String out, Key key, String path_in, Integer out_type) throws Exception {
        List<String> info = new ArrayList<>();
        Cr.DeEncr(path_in, key);
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT("de" + path_in);
                break;
            case "xml":
                info = XML.ReadXML("de" + path_in);
                break;
            case "json":
                info = JSON.ReadJSON("de" + path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out_type)
        {
            case 0:
                out_res(info, out);
                break;
            case 1:
                out_res1(info, out);
                break;
            case 2:
                out_res2(info, out);
                break;
            case 3:
                out_res3(info, out);
                break;
            case 4:
                out_res4(info, out);
                break;
        }
    }

    public void construct3(String in, String out, Key key, String path_in, Integer out_type) throws Exception {
        String type = archType;
        String zName = archPath;
        List<String> info = new ArrayList<>();
        String add = "new";
        Cr.DeEncr(zName, key);
        if(Objects.equals(type, "zip"))
        {
            Zip.Arch("de" + zName);
        }
        else
        {
            add = "j" + add;
            Jar.exJAR("de" + zName);
        }
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT(add + path_in);
                break;
            case "xml":
                info = XML.ReadXML(add + path_in);
                break;
            case "json":
                info = JSON.ReadJSON(add + path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out_type)
        {
            case 0:
                out_res(info, out);
                break;
            case 1:
                out_res1(info, out);
                break;
            case 2:
                out_res2(info, out);
                break;
            case 3:
                out_res3(info, out);
                break;
            case 4:
                out_res4(info, out);
                break;
        }
    }

    public void construct4(String in, String out, Key key, String path_in, Integer out_type) throws Exception {
        String type = archType;
        String zName = archPath;
        String add = "new";
        if(Objects.equals(type, "zip"))
        {
            Zip.Arch(zName);
        }
        else
        {
            add = "j" + add;
            Jar.exJAR(zName);
        }
        List<String> info = new ArrayList<>();
        Cr.DeEncr(add + path_in, key);
        add = "de" + add;
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT(add + path_in);
                break;
            case "xml":
                info = XML.ReadXML(add + path_in);
                break;
            case "json":
                info = JSON.ReadJSON(add + path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out_type)
        {
            case 0:
                out_res(info, out);
                break;
            case 1:
                out_res1(info, out);
                break;
            case 2:
                out_res2(info, out);
                break;
            case 3:
                out_res3(info, out);
                break;
            case 4:
                out_res4(info, out);
                break;
        }
    }

    public void out_res(List<String> info, String out) throws ParserConfigurationException, TransformerException, IOException {
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info, "result.txt");
                break;
            case "xml":
                XML.WriteXML(info, "result.xml");
                break;
            case "json":
                JSON.WriteJSON(info, "result.json");
                break;
        }
    }

    public void out_res1(List<String> info, String out) throws Exception {
        String type = archTypeOut;
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info, "r.txt");
                break;
            case "xml":
                XML.WriteXML(info, "r.xml");
                break;
            case "json":
                JSON.WriteJSON(info, "r.json");
                break;
        }

        if(Objects.equals(type, "zip"))
        {
            Zip.Z("r." + out, "result.zip");
        }
        else{
            List<String> in = new ArrayList<>();
            in.add("r." + out);
            Jar.ArchJAR(in, "result.jar");
        }
    }

    public void out_res2(List<String> info, String out) throws Exception {
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info, "r.txt");
                break;
            case "xml":
                XML.WriteXML(info, "r.xml");
                break;
            case "json":
                JSON.WriteJSON(info, "r.json");
                break;
        }
        Cr.Encr("r." + out, "result." + out);
    }

    public void out_res3(List<String> info, String out) throws Exception {
        String type = archTypeOut;
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info, "r.txt");
                break;
            case "xml":
                XML.WriteXML(info, "r.xml");
                break;
            case "json":
                JSON.WriteJSON(info, "r.json");
                break;
        }

        if(Objects.equals(type, "zip"))
        {
            Zip.Z("r." + out, "res.zip");
            Cr.Encr("res.zip", "result.zip");
        }
        else{
            List<String> in = new ArrayList<>();
            in.add("r." + out);
            Jar.ArchJAR(in, "res.jar");
            Cr.Encr("res.jar", "result.jar");
        }
    }

    public void out_res4(List<String> info, String out) throws Exception {
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info, "r.txt");
                break;
            case "xml":
                XML.WriteXML(info, "r.xml");
                break;
            case "json":
                JSON.WriteJSON(info, "r.json");
                break;
        }
        Cr.Encr("r." + out, "res." + out);
        String type = archTypeOut;
        if(Objects.equals(type, "zip"))
        {
            Zip.Z("res." + out, "result.zip");
        }
        else{
            List<String> in = new ArrayList<>();
            in.add("res." + out);
            Jar.ArchJAR(in, "result.jar");
        }
    }
}
