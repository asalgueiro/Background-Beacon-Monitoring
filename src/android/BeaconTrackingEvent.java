package backgroundbeacons;

import backgroundbeacons.BeaconEvent;
import backgroundbeacons.BeaconRegion;

import org.json.JSONObject;
import org.json.JSONException;

public class BeaconTrackingEvent {

  private String deviceId;
  private String apiToken;
  private BeaconEvent beaconEvent;
  private BeaconRegion region;
  private String timestamp;

  public BeaconTrackingEvent(String deviceId, String apiToken, BeaconEvent beaconEvent, BeaconRegion region, String timestamp) {
    this.deviceId = deviceId;
    this.apiToken = apiToken;
    this.beaconEvent = beaconEvent;
    this.region = region;
    this.timestamp = timestamp;
  }

  public JSONObject toJsonObject() {

    JSONObject response = new JSONObject();
    JSONObject beacon_event = new JSONObject();
    JSONObject device = new JSONObject();

    try {

      device.put("uuid", this.deviceId);
      device.put("timestamp", this.timestamp);
      beacon_event.put("device", device);
      beacon_event.put("region", this.region.toJsonObject());
      beacon_event.put("beacon", this.beaconEvent.toJsonObject());

      response.put("beacon_event", beacon_event);
      response.put("token", this.apiToken);
      response.put("accion", "beacon_detect");

    } catch (JSONException e) {
    }

    return response;

  }

}
