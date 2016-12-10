package task1.json.adapter;

import org.json.JSONException;
import org.json.JSONObject;
import task1.json.JsonSerializer;
import task1.json.adapter.JSONDataAdapter;

import java.util.Map;

/**
 * Converts all objects that extends java.util.Map to JSON Object
 */

public class MapAdapter implements JSONDataAdapter<Map> {

    @Override
    public Object toJson(Map map) throws JSONException {
        JSONObject m = new JSONObject();
        for (Object key : map.keySet()) {
            m.put(key.toString(), JsonSerializer.serialize(map.get(key)));
        }
        return m;
    }
}
