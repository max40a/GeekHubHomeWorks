package task1.json.adapter;

import org.json.JSONException;

import java.util.Collection;

/**
 * Converts all objects that extends java.util.Collections to JSONArray
 */

public class CollectionAdapter implements JSONDataAdapter<Collection> {

    @Override
    public Object toJson(Collection o) throws JSONException {
        if (o.size() == 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for (Object element : o) {
            result.append(element);
            result.append(",");
        }
        result.delete(result.length() - 1, result.length());
        result.append("]");

        return result.toString();
    }
}