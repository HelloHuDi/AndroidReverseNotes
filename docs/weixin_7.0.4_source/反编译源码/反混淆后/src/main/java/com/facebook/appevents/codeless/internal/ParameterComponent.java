package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ParameterComponent {
    private static final String PARAMETER_NAME_KEY = "name";
    private static final String PARAMETER_PATH_KEY = "path";
    private static final String PARAMETER_VALUE_KEY = "value";
    public final String name;
    public final List<PathComponent> path;
    public final String pathType;
    public final String value;

    public ParameterComponent(JSONObject jSONObject) {
        AppMethodBeat.m2504i(72101);
        this.name = jSONObject.getString("name");
        this.value = jSONObject.optString("value");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(PARAMETER_PATH_KEY);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(new PathComponent(optJSONArray.getJSONObject(i)));
            }
        }
        this.path = arrayList;
        this.pathType = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
        AppMethodBeat.m2505o(72101);
    }
}
