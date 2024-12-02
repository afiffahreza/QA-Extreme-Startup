package com.develogical;

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

        return "";
    }

}