package com.example.scanner;

import java.net.*;
import java.io.*;
import java.util.*;

class flaskApiCall{

    public static void flaskPostUpc(String[] args) throws Exception{

        String itemUpc = args[0];
        String parameter = "itemUpc=" + itemUpc;

        URL flaskUrl = new URL("http://127.0.0.1:5000/apiTestCall");
        HttpURLConnection connection = (HttpURLConnection) flaskUrl.openConnection();

        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

        writer.write(parameter);
        writer.flush();

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        writer.close();
        reader.close();
    }
}