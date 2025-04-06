package com.example.fib;

import com.example.fib.builders.Director;
import com.example.fib.builders.DirectorRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;

@RestController
@RequestMapping("h")
public class Controller {

    DirectorRest director = new DirectorRest();

    Key key;

    @GetMapping("/start")
    public String start(){
        return "Enter type of input file: xml, json, txt (\th/intype/xml, \th/intype/json, \th/intype/txt)";
    }

    @GetMapping("/intype/{type}")
    public String inpathxml(@PathVariable String type){
        director.in_type = type;
        return "Enter path to input file: h/inpath/(enter path)";
    }

    @GetMapping("/inpath/{path}")
    public String readxml(@PathVariable String path){
        director.input_path = path;
        return "Enter type of output file: xml, json, txt (\th/outtype/xml, \th/outtype/json, \th/outtype/txt)";
    }

    @GetMapping("/outtype/{type}")
    public String intype(@PathVariable String type){
        director.out_type = type;
        return ("Type /in/1 if input file is archived\nType /in/2 if input file is encrypted\nType /in/3 if input file is archived and then encrypted\nType /in/4 if input file is encrypted and then archived\nType /in/0 if none of those");
    }

    @GetMapping("/in/1")
    public String in1(){
        director.in = 1;
        return "Enter type of archive and path to it(/inzip/(enter path) or /injar/(enter path))";
    }

    @GetMapping("/inzip/{path}")
    public String zipIn(@PathVariable String zpath){
        director.archPath = zpath;
        director.archType = "zip";
        return ("Type /out/1 if output file is archived\nType /out/2 if output file is encrypted\nType /out/3 if output file is archived and then encrypted\nType /out/4 if output file is encrypted and then archived\nType /out/0 if none of those");
    }

    @GetMapping("/injar/{path}")
    public String jarIn(@PathVariable String jpath){
        director.archPath = jpath;
        director.archType = "jar";
        return ("Type /out/1 if output file is archived\nType /out/2 if output file is encrypted\nType /out/3 if output file is archived and then encrypted\nType /out/4 if output file is encrypted and then archived\nType /out/0 if none of those");
    }

    @GetMapping("/in/2")
    public String in2(){
        director.in = 2;
        return ("Type /out/1 if output file is archived\nType /out/2 if output file is encrypted\nType /out/3 if output file is archived and then encrypted\nType /out/4 if output file is encrypted and then archived\nType /out/0 if none of those");
    }

    @GetMapping("/in/3")
    public String in3(){
        director.in = 3;
        return "Enter type of archive and path to it(/inzip/(enter path) or /injar/(enter path))";
    }

    @GetMapping("/in/4")
    public String in4(){
        director.in = 4;
        return "Enter type of archive and path to it(/inzip/(enter path) or /injar/(enter path))";
    }

    @GetMapping("/in/0")
    public String in0(){
        director.in = 0;
        return ("Type /out/1 if output file is archived\nType /out/2 if output file is encrypted\nType /out/3 if output file is archived and then encrypted\nType /out/4 if output file is encrypted and then archived\nType /out/0 if none of those");
    }

    @GetMapping("/out/1")
    public String out1(){
        director.out = 1;
        return "Enter type of archive (/outzip or /outjar)";
    }

    @GetMapping("/outzip")
    public void outz() throws Exception {
        director.archTypeOut = "zip";
        director.construct(key);
    }

    @GetMapping("/outjar")
    public void outj() throws Exception {
        director.archTypeOut = "jar";
        director.construct(key);
    }

    @GetMapping("/out/2")
    public void out2() throws Exception {
        director.out = 2;
        director.construct(key);
    }

    @GetMapping("/out/3")
    public String out3(){
        director.out = 3;
        return "Enter type of archive (/outzip or /outjar)";
    }

    @GetMapping("/out/4")
    public String out4(){
        director.out = 4;
        return "Enter type of archive (/outzip or /outjar)";
    }

    @GetMapping("/out/0")
    public void out0() throws Exception {
        director.out = 0;
        director.construct(key);
    }
}