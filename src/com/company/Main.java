package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static String str;
    public static void main(String args[]) throws InterruptedException{
        try(ServerSocket server = new ServerSocket(1488)){
            Socket client = server.accept();
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            System.out.println("Accept");
            System.out.println();
            Messages messages;
            while(true) {
                messages = (Messages) in.readObject();
                Enter enter = (Enter) messages.getEnum();
                RequestHandler handler = new RequestHandler();
                String string = handler.consoleDecoder(messages);
                out.writeObject(string);
                out.flush();
            }
        }catch (ClassNotFoundException e){
            System.out.println("I catched it");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("I expected that");
        }catch (NullPointerException e){
            System.out.println("No elements in queu");
        }catch(ClassFormatError e){
            System.out.println("Not a string");
        }
    }
}
