/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rtasignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class ReadCharacter {

    private static final String FILENAME = "C:\\Users\\User\\desktop\\test.txt";

    public void readChar() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String line = br.readLine();
            int value;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            System.out.println("|Character|Count|");
            System.out.println("|:--:|:--:|");
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (map.containsKey(line.charAt(i))) {
                        value = map.get(line.charAt(i));
                        value++;
                        map.put(line.charAt(i), value);
                    } else {
                        map.put(line.charAt(i), 1);
                    }
                }
                line = br.readLine();
            }
            for (Character key : map.keySet()) {
                System.out.printf("| '%c' |   %5d |\n", key, map.get(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
