/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rtasignment2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author User
 */
public class Asignment2 {
            
        
    public static void main(String [] args) throws IOException, InvalidFormatException{
        
        long startTime = System.nanoTime();
        long start2 = System.nanoTime();
        
        System.out.println("Convert .xlsx to .txt \n");
        readwrite r = new readwrite();
        r.readData();
        
        System.out.println("Read test.txt file ....\n");
        System.out.println("Calculate and analyse data......\n");
        System.out.println("Open writer to Result.md file...\n");
        
        PrintStream out = new PrintStream(new FileOutputStream("C:/Users/User/240842-STIW3054-A172-A2.wiki/Result.md"));
        System.setOut(out);
        
        System.out.println("# Asignment 2 - STIW3054 A172 - 240842 \n");
        
        System.out.println("## Analyse data from list of students \n");

        System.out.println("## `Result` \n");
        
        System.out.println("### `General Details` \n");
        analyseData d = new analyseData();
        
        d.countWord(); 
        d.readDetails(); 
        System.out.println("\n\n### `Details for each line` \n");
        d.analyseLine();
        System.out.println("\n\n### `Details for each character` \n");
        d.readChar(); 
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        double seconds = (double) elapsedTime / 1000000000.0;
        
        System.out.printf("\n`Complete calculation execution = %.9f seconds`", seconds);
        
        
        PrintStream consoleStream = new PrintStream(new FileOutputStream(FileDescriptor.out));
        out.close();
        System.setOut(consoleStream);
        
        System.out.println("Closing file output stream ........ \n");
        System.out.println("Run CMD to push to github....");
        System.out.println();
       
        
        
        
        long startPush = System.nanoTime();
        //System.out.println("Closing file ....");
        
        //String[] command = {"C:/Program Files/Git/git-bash.exe"};
        //Runtime.getRuntime().exec(command);
        gitHub g1 = new gitHub();
        g1.runTerminal(); 
        
        long lastStop = System.nanoTime();
        long diff = lastStop - start2;
        long gitTime = lastStop - startPush;
        double fullSeconds = (double) diff / 1000000000.0;
        double pushSeconds = (double) gitTime / 1000000000.0;
        System.out.printf("\nComplete upload at GitHub = %.9f seconds", pushSeconds);
        System.out.printf("\nComplete all process = %.9f seconds", fullSeconds);
    }
}
