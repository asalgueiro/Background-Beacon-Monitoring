package backgroundbeacons;

import backgroundbeacons.BeaconEvent;
import backgroundbeacons.BeaconRegion;

import org.json.JSONObject;
import org.json.JSONException;

public class RegionTrackingEvent {

  private String deviceId;
  private String eventType;
  private BeaconRegion region;
  private String timestamp;

  public RegionTrackingEvent(String deviceId, String eventType, BeaconRegion region, String timestamp) {
    this.deviceId = deviceId;
    this.eventType = eventType;
    this.region = region;
    this.timestamp = timestamp;
  }

  public JSONObject toJsonObject() {

    JSONObject response = new JSONObject();
    JSONObject region_event = new JSONObject();
    JSONObject device = new JSONObject();

    try {

      device.put("uuid", this.deviceId);
      device.put("timestamp", this.timestamp);

      region_event.put("event_type", this.eventType);
      region_event.put("device", device);
      region_event.put("region", this.region.toJsonObject());

      response.put("region_event", region_event);
      response.put("accion", "beacon_detect");



    } catch (JSONException e) {
    }

    return response;

  }

}
