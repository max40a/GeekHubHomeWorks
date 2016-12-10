package task1.json.adapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Collection;

/**
 * Converts all objects that extends java.util.Collections to JSONArray
 */

public class CollectionAdapter implements JSONDataAdapter<Collection> {

    @Override
    public Object toJson(Collection o) throws JSONException {
        JSONArray a = new JSONArray();
        for (Object element : o) {
            a.put(element);
        }
        return a;
    }
}