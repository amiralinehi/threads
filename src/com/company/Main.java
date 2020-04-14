package com.company;

public class Main {

    public static void main(String[] args)
    {
        /*
                creating five threads with different
                documents to read 
         */

        Thread thread_1 =new Thread(new MultiTreads("document_1.txt"));
        thread_1.start();


        Thread thread_2 =new Thread(new MultiTreads("document_2.txt"));
        thread_2.start();

        Thread thread_3 =new Thread(new MultiTreads("document_3.txt"));
        thread_3.start();


        Thread thread_4 =new Thread(new MultiTreads("document_4.txt"));
        thread_4.start();


        Thread thread_5 =new Thread(new MultiTreads("document_5.txt"));
        thread_5.start();


    }


}