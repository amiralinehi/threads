package com.company;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiTreads  implements  Runnable {
    String address="";

    public MultiTreads(String address){

       this.address=address;

    }

    public  void  run ()
    {

        System.out.println(Thread.currentThread().getId());
        try {
            ReadingFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadingFile() throws IOException {

        // TODO: 4/14/2020  file reading operation

        FileReader fr = new FileReader(address);
        BufferedReader br=new BufferedReader(fr);
        StringBuffer sb=new StringBuffer();
        String line;

        while ((line=br.readLine())!=null)
        {

            sb.append(line);
            sb.append("\n");

        }

        System.out.println(FindKey(sb.toString()));
    }

    private boolean FindKey(String str) {

        if (str.contains("key")){
            return true;
        }

        return false;
    }


}
