package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

public class Property {
    public static JSONObject toJSONObject(Properties properties) {
        AppMethodBeat.i(50213);
        JSONObject jSONObject = new JSONObject();
        if (!(properties == null || properties.isEmpty())) {
            Enumeration propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                jSONObject.put(str, properties.getProperty(str));
            }
        }
        AppMethodBeat.o(50213);
        return jSONObject;
    }

    public static Properties toProperties(JSONObject jSONObject) {
        AppMethodBeat.i(50214);
        Properties properties = new Properties();
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                properties.put(obj, jSONObject.getString(obj));
            }
        }
        AppMethodBeat.o(50214);
        return properties;
    }
}
