package task1.json.adapter;

import org.json.JSONException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Converts object of type java.time.LocalDate to Sting by using ISO 8601 format
 */

public class LocalDateAdapter implements JSONDataAdapter<LocalDate> {

    @Override
    public Object toJson(LocalDate o) throws JSONException {
        return o.getYear() + "-" + o.getMonth().getValue() + "-" + o.getDayOfMonth();
    }
}