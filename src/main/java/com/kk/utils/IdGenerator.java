package com.kk.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class IdGenerator {

    public static String generateRandomAlphabet(Integer length){
        if(length == null){
            length = 4;
        }

        boolean useLetters = true;
        boolean useNumbers = false;

        return RandomStringUtils.random(length, useLetters, useNumbers).toUpperCase();
    }

    public static String generateRandomDigit(Integer x){
        if (x == null){
            x = 4;
        }

        Random random = new Random();

        return String.format("%0" + x + "d", random.nextInt(10000));
    }

    public static String generateIds(Integer length){

        String alphabets = generateRandomAlphabet(length);
        String numbers  = generateRandomDigit(length);

        return alphabets + "-" + numbers;
    }

    public static String generateUserId(){
        return "US-" + generateIds(null);
    }

    public static String generatePlotId(){
        return "PL-" + generateIds(null);
    }

    public static String generateRoomId(){
        return "RM-" + generateIds(null);
    }

    public static String generateLandlordIt(){
        return "LD-" + generateIds(null);
    }

    public static String generateTenantId(){
        return "TN-" + generateIds(null);
    }
}
