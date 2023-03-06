package com.epam.mjc.io;

import java.io.File;

import java.io.BufferedReader;
import java.io.Reader;

public class FileReader extends Reader {

   @Override
   public int read(char[] cbuf, int off, int len)  {
    return 0;}

   @Override
   public void close()  {}
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    if ("Name".equals(key)) {
                        profile.setName(value);
                    } else if ("Age".equals(key)) {
                        int age = Integer.parseInt(value.trim());
                        profile.setAge(age);
                    } else if ("Email".equals(key)) {
                        profile.setEmail(value);
                    } else if ("Phone".equals(key)) {
                        long phone = Long.parseLong(value.trim());
                        profile.setPhone(phone);
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
            return profile;
    }
}




