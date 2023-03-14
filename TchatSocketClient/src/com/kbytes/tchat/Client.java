package com.kbytes.tchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client{
	
	public static void main(String[] args) {;
	    Socket socket ;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
        	InetAddress address =InetAddress.getLocalHost();
        	//String address = "192.168.100.93";
        	 socket = new Socket(address,2009);
        	 System.out.println("Connection request...");
        	 in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
        	 out = new PrintWriter(socket.getOutputStream());
        	 String message_distant = in.readLine();
             System.out.println(message_distant);
             Thread t3 = new Thread(new Reception(in,"SERVEUR"));
             t3.start();
             Thread t4 = new Thread(new Emission(out));
             t4.start();
        }catch (IOException e) {
            e.printStackTrace();
        }
	}
}
