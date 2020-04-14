package com.company;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*
 TODO: 4/15/2020
  how stop other threads when output is true
*/


// main Thread with run method
public class MultiTreads  implements  Runnable {
    String address="";

    public MultiTreads(String address){

       this.address=address;

    }
    /* calls for ReadFile to apply
     it to all existing threads */

    public  void  run ()
    {

        System.out.println(Thread.currentThread().getId());
        try {
            ReadingFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read file from given string as address
    public void ReadingFile() throws IOException {


        FileReader fr = new FileReader(address);
        BufferedReader br=new BufferedReader(fr);
        StringBuffer sb=new StringBuffer();
        String line;

        while ((line=br.readLine())!=null)
        {

            sb.append(line);
            sb.append("\n");

        }
        /* return true or
         false depends on
         whether FindKey is true or not */
        System.out.println(FindKey(sb.toString()));
    }

    // find a given string in file
    private boolean FindKey(String str) {

        if (str.contains("key")){
            return true;
        }

        return false;
    }


}
