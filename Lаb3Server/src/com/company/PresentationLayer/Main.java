package com.company.PresentationLayer;

import com.company.BusinessLayer.BusinessClass;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static ServerSocket server;
    private static Socket clientSocket;
    private static BufferedReader input;
    private static BufferedWriter output;

    public static void main(String[] args) {
        try {
            try {

                System.out.println("Starting server!");
                server = new ServerSocket(4004);
                System.out.println("Server active!");
                clientSocket = server.accept();
                System.out.println("Connection established!");
                try{
                    input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    String command = input.readLine();
                    System.out.println(command);
                    boolean isExit = false;
                    while(!isExit){
                        switch (command){
                            case "Add":
                                String student = input.readLine();
                                System.out.println(student);
                                new BusinessClass().addStudent(student);
                                output.write("New student successfully added.");
                                output.flush();
                                break;
                            case "View":
                                int individualNumber = Integer.parseInt(input.readLine());
                                output.write(new BusinessClass().studentProfile(individualNumber));
                                output.flush();
                                break;
                            case "Change":
                                student = input.readLine();
                                new BusinessClass().changeStudent(student);
                                output.write("Students info successfully changed.");
                                output.flush();
                                break;
                            case "Delete":
                                student = input.readLine();
                                new BusinessClass().deleteStudents(student);
                                output.write("Student successfully deleted.");
                                output.flush();
                                break;
                            case "Exit":
                                isExit = true;
                                break;
                            default:
                                output.write("Something is not right.");
                                output.flush();
                                break;
                        }
                    }
                }finally {
                    input.close();
                    output.close();
                    clientSocket.close();
                }
            }finally {
                server.close();
            }
    }catch(IOException e){
            e.printStackTrace();
        }
    }
}
