package task1.json.adapter;

import org.json.JSONArray;
import org.json.JSONException;
import task1.json.JsonSerializer;

import java.util.Collection;

/**
 * Converts all objects that extends java.util.Collections to JSONArray
 */

public class CollectionAdapter implements JSONDataAdapter<Collection> {

    @Override
    public Object toJson(Collection o) throws JSONException {
        JSONArray result = new JSONArray();
        for(Object object : o) {
            result.put(JsonSerializer.serialize(object));
        }
        return result;
    }
}