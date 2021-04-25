package com.company;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static String str;
    public static void main(String args[]) throws InterruptedException{

        Collection database = new Collection();

        try(ServerSocket server = new ServerSocket(1488)){
            System.out.println("Server has started");
            Socket client = server.accept();
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            System.out.println("Accept");
            System.out.println();
            Messages messages;
            RequestHandler handler = new RequestHandler(database);
            while(true) {
                messages = (Messages) in.readObject();
                Enter enter = (Enter) messages.getEnum();
                String string = handler.consoleDecoder(messages);
                System.out.println("string:" + string);
                out.writeObject(string);
                out.flush();
            }
        }catch (ClassNotFoundException e){
            System.out.println("I catched it");
        }catch (EOFException e){
            System.out.println("Client application has been closed.");
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
