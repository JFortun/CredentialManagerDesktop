package org.fortun.credmandesk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HTTPClient {

    static ArrayList<String> users;
    static JSONArray result;
    static JSONObject jsonobject;
    static String nameUser, passwordUser;
    static int idUser, position;


    public static void create(String nameUser, String passwordUser) {
        try {
            URL url = new URL("http://localhost:8080/api/users");
            HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();
            myConnection.setRequestMethod("POST");
            HashMap<String, String> postDataParams = new HashMap<>();
            postDataParams.put("nameUser", nameUser);
            postDataParams.put("passwordUser", passwordUser);
            myConnection.setDoInput(true);
            myConnection.setDoOutput(true);
            OutputStream os = myConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
            writer.write(getDataString(postDataParams));
            writer.flush();
            writer.close();
            os.close();
            myConnection.getResponseCode();
            if (myConnection.getResponseCode() == 201) {
                System.out.println("Created");
                myConnection.disconnect();
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<String> read(String type, String parameter) {
        users = new ArrayList<>();
        try {
            URL url = null;
            switch (type) {
                case "findAll":
                    url = new URL("http://localhost:8080/api/users");
                    break;
                case "findById":
                    url = new URL("http://localhost:8080/api/users/id/" + parameter);
                    break;
                case "findByName":
                    url = new URL("http://localhost:8080/api/users/name/" + parameter);
                    break;
            }
            assert url != null;
            HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();
            myConnection.setRequestMethod("GET");
            if (myConnection.getResponseCode() == 200) {
                InputStream responseBody = myConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, StandardCharsets.UTF_8);
                BufferedReader bR = new BufferedReader(responseBodyReader);
                String line;
                StringBuilder responseStrBuilder = new StringBuilder();
                while ((line = bR.readLine()) != null) {
                    responseStrBuilder.append(line);
                }
                if (type.equals("findAll")) {
                    result = new JSONArray(responseStrBuilder.toString());
                    position = 0;
                    jsonobject = result.getJSONObject(position);
                } else {
                    jsonobject = new JSONObject(responseStrBuilder.toString());
                }
                idUser = jsonobject.getInt("idUser");
                nameUser = jsonobject.getString("nameUser");
                passwordUser = jsonobject.getString("passwordUser");
                responseBody.close();
                responseBodyReader.close();
                myConnection.disconnect();
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            users.clear();
            if (type.equals("findAll")) {
                if (result != null) {
                    int longitud = result.length();
                    for (int i = 0; i < longitud; i++) {
                        jsonobject = result.getJSONObject(i);
                        users.add(jsonobject.getString("nameUser"));
                    }
                }
            } else {
                Main.user.setIdUser((long) jsonobject.getInt("idUser"));
                Main.user.setNameUser(jsonobject.getString("nameUser"));
                Main.user.setPasswordUser(jsonobject.getString("passwordUser"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void update(int idUser, String nameUser, String passwordUser) {
        try {
            URL url = new URL("http://localhost:8080/api/users/id/" + idUser);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            HashMap<String, String> postDataParams = new HashMap<>();
            postDataParams.put("nameUser", nameUser);
            postDataParams.put("passwordUser", passwordUser);

            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
            writer.write(getDataString(postDataParams));
            writer.flush();
            writer.close();
            os.close();

            if (connection.getResponseCode() == 201) {
                System.out.println("Updated");
                connection.disconnect();
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void delete(String idUser) {
        try {
            URL url = new URL("http://localhost:8080/api/users/id/" + idUser);
            HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();
            myConnection.setRequestMethod("DELETE");
            if (myConnection.getResponseCode() == 204) {
                System.out.println("Deleted");
                myConnection.disconnect();
            } else {
                System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String getDataString(HashMap<String, String> params) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        return result.toString();
    }
}
