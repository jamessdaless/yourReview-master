package uk.ac.tees.p4072709.yourreview;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class returnData extends AsyncTask <Void, Void, Void> {
    String results = "";
    String dataParsed = "";
    String singleParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {
      try {
          URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=artist.search&artist="+ Search.artist.getText() +"&api_key=0b50852873b33737ca23687f1fc44097&format=json");
          HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
          InputStream inputStream = httpURLConnection.getInputStream();
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
          String line = "";
          while(line != null){
              line = bufferedReader.readLine();
              results = results + line;
          }

         JSONArray JA = new JSONArray(results);
          for (int i=0; i < JA.length(); i++) {
              JSONObject JO = (JSONObject) JA.get(i);
              singleParsed = "Name: " + JO.get("name") + "\n" + "Listeners: " + JO.get("listeners") + "\n" + "URL: " + JO.get("url") + "\n";

              dataParsed = dataParsed + singleParsed + "\n";
          }

      } catch (MalformedURLException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      } catch (JSONException e) {
          e.printStackTrace();
      }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Search.results.setText(this.results);
    }
}
