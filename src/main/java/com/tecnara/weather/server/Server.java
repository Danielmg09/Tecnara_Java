package com.tecnara.weather.server;

import com.tecnara.weather.server.domain.Coordinates;
import com.tecnara.weather.server.domain.openweather.Openweather;
import com.tecnara.weather.server.services.openweather.OpenWeatherServices;
import com.tecnara.weather.server.utils.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(3333);
            System.out.println("Listening...");

            while(true){

                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String coordinates = dis.readUTF();
                System.out.println("Coordinates received");

                Coordinates coord = Utils.parseCoordinates(coordinates);
                Openweather openinfo = OpenWeatherServices.getCurrentMeteo(coord);
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(openinfo.toMessage());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
