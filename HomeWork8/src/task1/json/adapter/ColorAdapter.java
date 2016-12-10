package task1.json.adapter;

import org.json.JSONException;

import java.awt.*;


/**
 * Converts object of type java.awt.Color to it's String representation.
 * i.e. Color.GRAY = "(128,128,128)"
 */

public class ColorAdapter implements JSONDataAdapter<Color> {

    @Override
    public Object toJson(Color o) throws JSONException {
        return "(" + o.getRed() + "," + o.getGreen() + "," + o.getBlue() + ")";
    }
}