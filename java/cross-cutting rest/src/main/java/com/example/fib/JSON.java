package com.example.fib;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSON {
    public static List<String> ReadJSON(String filename) {
        List<String> info = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray list = (JSONArray) jsonParser.parse(new FileReader(filename));
            for (int i = 0; i < list.size(); ++i) {
                JSONObject object = (JSONObject) list.get(i);
                String str;
                str = (String) object.get("line");
                info.add(str);
            }
        } catch (IOException | ParseException ex) {
            throw new RuntimeException(ex);
        }
        return info;
    }

    public static void WriteJSON(List<String> p) throws IOException {
        FileWriter writer = new FileWriter("out_file.json");
        JSONArray obj = new JSONArray();
        writer.write("[ ");
        for (int i = 0; i < p.size(); ++i) {
            if (i + 1 == p.size()) {
                JSONObject object = new JSONObject();
                object.put("line", p.get(i));
                writer.write(object.toJSONString());
                break;
            }
            JSONObject object = new JSONObject();
            object.put("line", p.get(i));
            writer.write(object.toJSONString() + ",\n");
        }
        writer.write(" ]");
        writer.flush();
    }

    public static void WriteJSON(List<String> p, String file) throws IOException {
        FileWriter writer = new FileWriter(file);
        JSONArray obj = new JSONArray();
        writer.write("[ ");
        for (int i = 0; i < p.size(); ++i) {
            if (i + 1 == p.size()) {
                JSONObject object = new JSONObject();
                object.put("line", p.get(i));
                writer.write(object.toJSONString());
                break;
            }
            JSONObject object = new JSONObject();
            object.put("line", p.get(i));
            writer.write(object.toJSONString() + ",\n");
        }
        writer.write(" ]");
        writer.flush();
    }
}
