package com.company.scripting;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ScriptException {
        var manager = new ScriptEngineManager();
        var engine = manager.getEngineByName("graal.js");
        var script = "48+2";
        System.out.println(engine.eval(script));

        try (var reader = new FileReader("calculate.js")) {
            var jsval = (Integer) engine.eval(reader);
            var output = String.format("The result from external js file is %d", jsval);
            System.out.println(output);
        } catch (IOException ix) {
            ix.printStackTrace();
        }
    }
}
