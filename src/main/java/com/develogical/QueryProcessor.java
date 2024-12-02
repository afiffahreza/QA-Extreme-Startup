package com.develogical;

import java.util.*;

public class QueryProcessor {

    public String process(String query) {

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.contains("your name")) {
            return "afifbenjasonthaddeus";
        }

        if (query.contains("plus")) {
            // remove trailing ?
            query = query.substring(0, query.length() - 1);
            String[] parts = query.split(" ");
            int first = Integer.parseInt(parts[2]);
            int second = Integer.parseInt(parts[4]);
            return Integer.toString(first + second);
        }

        if (query.contains("largest")) {
            String numbers = query.split(":")[1];
            numbers = numbers.replaceAll("\\s+", "");
            numbers = numbers.substring(0, numbers.length() - 1);
            List<String> temp = Arrays.asList(numbers.split(","));
            int max = -999999999;
            for (String n : temp) {
                int a = Integer.parseInt(n);
                max = Math.max(a, max);
            }
            return String.valueOf(max);
        }

        if (query.contains("multiplied")) {
            // remove trailing ?
            query = query.substring(0, query.length() - 1);
            String[] parts = query.split(" ");
            int first = Integer.parseInt(parts[2]);
            int second = Integer.parseInt(parts[5]);
            return Integer.toString(first * second);
        }

        return "";
    }

}