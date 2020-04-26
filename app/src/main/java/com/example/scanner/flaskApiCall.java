package com.example.scanner;

import android.os.AsyncTask;

import java.net.*;
import java.io.*;
import java.util.*;

class flaskApiCall extends AsyncTask<String[], Integer, String> {

    @Override
    protected String doInBackground(String[]... strings) {

        String[] itemUpc = strings[0];
        String parameter = "itemUpc=" + itemUpc[0];

        try {
            URL flaskUrl = new URL("http://107.12.107.68:5000/apiTestCall");
            System.out.println("Instantiated url");
            HttpURLConnection connection = (HttpURLConnection) flaskUrl.openConnection();
            System.out.println("Connection Made");
            connection.setDoOutput(true);
            connection.setChunkedStreamingMode(0);
            System.out.println("doOutput Set to true");
            connection.setRequestMethod("POST");
            System.out.println("Request method set to post");

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

        } catch (IOException e) {
            e.printStackTrace();
        }


        return parameter;
    }
}