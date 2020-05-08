package com.company;

public class Main {

    public static void main (String[] args) throws InterruptedException {

        /*initializing threads */
         Thread t =Thread.currentThread();

        String[] documents = new String[5];
        documents[0] = "document_1.txt";
        documents[1] = "document_1.txt";
        documents[2] = "document_2.txt";
        documents[3] = "document_1.txt";
        documents[4] = "document_1.txt";


        for (int i = 0; i < documents.length; i++) {

                Thread object = new Thread(new MultiTreads(documents[i]));
                Thread.sleep(2000);
                object.start();

            }

        }
    }
