/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;

/**
 *
 * @author ADMIN
 */
public class Translate1 {
    public String callTranslate(String langFrom, String langTo,
                                             String word) throws Exception 
    {

        String url = "https://translate.googleapis.com/translate_a/single?"+
        "client=gtx&"+
        "sl=" + langFrom + 
        "&tl=" + langTo + 
        "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");    
  
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection(); 
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
 
        StringBuilder response;
        try (BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }  
        }
 
        return parseResult(response.toString());
    }
 
    public String parseResult(String inputJson) throws Exception{
  /*
   * inputJson for word 'hello' translated to language Hindi from English-
   * [[["नमस्ते","hello",,,1]],,"en"]
   * We have to get 'नमस्ते ' from this json.
   */
  
        JSONArray jsonArray = new JSONArray(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);
  
        return jsonArray3.get(0).toString();
    }
}
