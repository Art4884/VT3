package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static Socket clientSocket;
    private static BufferedReader input;
    private static BufferedWriter output;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Connection...");
        clientSocket = new Socket("localhost", 4004);
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println("Please, choose what you want to do:\n" +
                "\"Authorization\" if you want to enter system;\n" +
                "\"Registration\" if you you are new user;\n" +
                "\"Exit\" if you want to exit.");
        boolean isExit = false;
        while(!isExit){
            System.out.print("Write here: ");
            String command = scan.nextLine();
            output.write(command + "\n");
            System.out.println(command);
            output.flush();
//            switch (command){
//                case "Add":
//                    output.write("Add");
//                    System.out.println("Add in process");
//                    //output.write("Artemiy Tev 95100240 951007");
//                    output.flush();
//            }
        }
    }
}
