package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/*
 TODO: 4/15/2020
  how stop other threads when output is true
*/


// main Thread with run method
public class MultiTreads  implements  Runnable {
    String address;
    public MultiTreads(String address){

       this.address=address;

    }
    /* calls for ReadFile to apply
     it to all existing threads */

    public  void  run ()
    {

            System.out.println("thread with id : "+ Thread.currentThread().getId()+" is running");
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
        StringBuilder sb=new StringBuilder();
        String line;

        while ((line=br.readLine())!=null)
        {

            sb.append(line);
            sb.append("\n");

        }
        /* return true or
         false depends on
         whether FindKey is true or not */
        System.out.println("result by thread with id "+Thread.currentThread().getId()
                +" is "+(FindKey(sb.toString())));

    }

    // find a given string in file
    private boolean FindKey(String str) {

        return str.contains("key");
    }

}
