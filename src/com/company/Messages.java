package com.company;

import java.io.Serializable;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Messages implements Serializable {
    public ArrayList<Object> strings = new ArrayList<Object>();

    public void addString(String str){
        this.strings.add(str);
    }
    public void addCustom(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while(str!="exit"){
            this.addString(str);
            str = scanner.nextLine();
        }
    }
    public Enter getEnum(){
        try{
            if (this.strings.get(0).getClass()==Enter.class){
                return (Enter) this.strings.get(0);
            }
            else {
                return Enter.ERROR;
            }}catch (IndexOutOfBoundsException e){
            return Enter.ERROR;
        }
    }
}
