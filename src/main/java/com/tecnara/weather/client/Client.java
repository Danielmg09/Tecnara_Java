package com.tecnara.weather.client;

import com.tecnara.weather.client.utils.Utils;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String coordinates = Utils.askCoordinates();

        try {
            Socket s = new Socket("localhost",3333);

            if (Utils.checker(coordinates)) {

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(coordinates);

                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println(dis.readUTF());
            }else{
                System.out.println("This coordinates are not correct");
            }




        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
