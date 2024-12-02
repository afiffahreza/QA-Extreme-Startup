package com.develogical;

import java.util.*;

public class QueryProcessor {

    boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

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

        if (query.contains("square")) {
            String numbers = query.split(":")[1];
            numbers = numbers.replaceAll("\\s+", "");
            numbers = numbers.substring(0, numbers.length() - 1);
            List<String> temp = Arrays.asList(numbers.split(","));
            for (String n : temp) {
                int a = Integer.parseInt(n);
                int sqrt = (int) Math.sqrt(a);
                boolean square = sqrt * sqrt == a;

                int cbrt = (int) Math.cbrt(a);
                boolean cube = cbrt * cbrt * cbrt == a;

                if (square && cube) {
                    return String.valueOf(a); 
                }
            }
        }

        if (query.contains("prime")) {
            String numbers = query.split(":")[1];
            numbers = numbers.replaceAll("\\s+", "");
            numbers = numbers.substring(0, numbers.length() - 1);
            List<String> temp = Arrays.asList(numbers.split(","));
            List<String> tracker = new ArrayList<>();
            for (String n : temp) {
                int a = Integer.parseInt(n);
                if (isPrime(a)) {
                    tracker.add(String.valueOf(a));
                }
            }
            return String.join(", ", tracker);
        }

        if (query.contains("minus")) {
            // remove trailing ?
            query = query.substring(0, query.length() - 1);
            String[] parts = query.split(" ");
            int result = Integer.parseInt(parts[2]);
            for (int i = 4; i < parts.length; i += 2) {
                result -= Integer.parseInt(parts[i]);
            }
            return Integer.toString(result);
        }

        return "";
    }

}