package backgroundbeacons;

import backgroundbeacons.SharedPreferencesUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import android.util.Log;
import java.net.URL;
import java.net.HttpURLConnection;

import backgroundbeacons.BeaconTrackingEvent;
import backgroundbeacons.RegionTrackingEvent;

public class BeaconTrackingService {

  private SharedPreferencesUtility settings;
  private final String apiUrl;

  public BeaconTrackingService(SharedPreferencesUtility settings) {

    this.settings = settings;
    this.apiUrl = this.settings.getApiUrl();
  }

  public void EnterRegionEvent(RegionTrackingEvent event) {
      try {
        String json = event.toJsonObject().toString();
        URL url = new URL(this.apiUrl + "?enterRegion=" + String.valueOf(json.getBytes().length));

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "text/plain;charset=utf-8");
        //conn.setRequestProperty("Accept", "application/json");

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {

      }

  }

  public void ExitRegionEvent(RegionTrackingEvent event) {
      try {
        String json = event.toJsonObject().toString();
        URL url = new URL(this.apiUrl+ "?exitRegion=" + String.valueOf(json.getBytes().length));

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "text/plain;charset=utf-8");
        //conn.setRequestProperty("Accept", "application/json");

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {

      }

  }

  public void RangeBeaconEvent(BeaconTrackingEvent event) {
      try {
        String json = event.toJsonObject().toString();
        URL url = new URL(this.apiUrl + "?beaconEvent=" + String.valueOf(json.getBytes().length));

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "text/plain;charset=utf-8");
        //conn.setRequestProperty("Accept", "application/json");

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {

      }


  }

}
