package com.kbytes.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	
	public static void main(String[] args) {
		ServerSocket serverSocket  ;
	    Socket socket ;
        BufferedReader in;   
        PrintWriter out;
        try {
        	serverSocket = new ServerSocket(2009);
        	System.err.println("Server is listening on port "+serverSocket.getLocalPort());
        	socket = serverSocket.accept(); 
            System.out.println("A client is connected !");
       	 	in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
       	 	out = new PrintWriter(socket.getOutputStream());
            out.println("You're connected !");
            out.flush();
            Thread t3 = new Thread(new Reception(in,"CLIENT"));
            t3.start();
            Thread t4 = new Thread(new Emission(out));
            t4.start();
            serverSocket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
	}
}
