package task1.json.adapter;

import org.json.JSONException;

/**
 * JSONDataAdapter contains instructions how to serialize Java object to JSON representation
 * @param <T> determines type adapter works with
 */

public interface JSONDataAdapter<T> {
    Object toJson(T o) throws JSONException;
}
