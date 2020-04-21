package com.company;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/*  TODO: 4/19/2020
   if there is no key word return no such a word*/


// main Thread with run method
public class MultiTreads  extends   Thread {

    String address;
    public  volatile boolean process = true;

    public MultiTreads(String address) {

        this.address = address;


    }
    /* calls for ReadFile to apply
     it to all existing threads */

    public void run() {

        System.out.println("thread with id : " + Thread.currentThread().getId() + " is running");
        while (process) {
            try {
                ReadingFile();

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // read file from given string as address
    public void ReadingFile() throws IOException, InterruptedException {

        if (!Thread.currentThread().isInterrupted()) {

            FileReader fr = new FileReader(address);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append("\n");
            }
        /* return true or
         false depends on
         whether FindKey is true or not */
            System.out.println("result by thread with id " + Thread.currentThread().getId()
                    + " is " + (FindKey(sb.toString())));
        }
    }

    // find a given string in file
    private boolean FindKey(String str) throws InterruptedException {

        if (str.contains("key")) {
            Terminate();
            Thread.currentThread().interrupt();
            return true;
        }

        /*
        join() waits for thread to die since
        stop is deprecated */

        Thread.currentThread().join();
        return false;

    }
    @NotNull
    //a method for setting volatile boolean false `
    public void  Terminate(){
        process=false;
    }
}
