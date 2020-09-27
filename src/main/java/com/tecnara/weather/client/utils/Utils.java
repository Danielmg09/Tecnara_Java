package com.tecnara.weather.client.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static boolean checker(String coordinates){
        String regExp = "\\{\"lon\":-?\\d{1,3}.\\d{0,2}, \"lat\":-?\\d{1,2}.\\d{0,2}}";
        Matcher matcher = Pattern.compile(regExp).matcher(coordinates);
        return matcher.matches();
    }

    public static boolean checkFormat(String coordinates) {
        String regExp = "\\{\"lon\":-?\\d{1,3}.\\d{0,2}, \"lat\":-?\\d{1,2}.\\d{0,2}}";
        //{"lon":46.07, "lat":2.10}
        Matcher matcher = Pattern.compile(regExp).matcher(coordinates);
        return matcher.matches();
    }


    public static String askCoordinates(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce latitude: ");
        float latitude = sc.nextFloat();
        System.out.println("Introduce longitude: ");
        float longitude = sc.nextFloat();
        String coordinates = "{\"lon\":" + longitude + ", \"lat\":" + latitude + "}";
        return coordinates;
    }
}
