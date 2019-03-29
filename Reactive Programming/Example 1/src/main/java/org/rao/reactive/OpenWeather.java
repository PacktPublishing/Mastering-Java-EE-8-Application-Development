package org.rao.reactive;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class OpenWeather {
    public static double getTemperature(final String city) {

        try {
            Thread.sleep(1000);
            String appId =  "";
             final URL url =
                    new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID="+appId+"&units=metric");


            final BufferedReader reader =
                    new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            final String data = reader.lines().limit(1).findFirst().get();

            JSONParser parser = new JSONParser();
            Object obj  = parser.parse(data);
            JSONArray array = new JSONArray();
            array.add(obj);
            JSONObject jsonObject = (JSONObject) array.get(0);

            JSONObject main = (JSONObject) jsonObject.get("main");

            return Double.parseDouble(main.get("temp").toString());
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
