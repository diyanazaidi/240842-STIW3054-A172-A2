/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rtasignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;

/**
 *
 * @author User
 */
public class gitHub {
    
    public void runTerminal() throws IOException{
        try{
          
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd && cd \"C:\\Users\\User\\240842-STIW3054-A172-A2.wiki\" && git add * && git commit -m \"Test\" && git pull && git push");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        System.out.println("\nCMD result : \n");
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
        sleep(5000);
        }catch(Exception e){
            System.out.println("Terminal cannot run");
        }
    }
    
}
