package com.facebook.appevents.codeless.internal;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventBinding {
    private final String activityName;
    private final String appVersion;
    private final String componentId;
    private final String eventName;
    private final MappingMethod method;
    private final List<ParameterComponent> parameters;
    private final List<PathComponent> path;
    private final String pathType;
    private final ActionType type;

    public enum ActionType {
        CLICK,
        SELECTED,
        TEXT_CHANGED;

        static {
            AppMethodBeat.o(72093);
        }
    }

    public enum MappingMethod {
        MANUAL,
        INFERENCE;

        static {
            AppMethodBeat.o(72096);
        }
    }

    public EventBinding(String str, MappingMethod mappingMethod, ActionType actionType, String str2, List<PathComponent> list, List<ParameterComponent> list2, String str3, String str4, String str5) {
        this.eventName = str;
        this.method = mappingMethod;
        this.type = actionType;
        this.appVersion = str2;
        this.path = list;
        this.parameters = list2;
        this.componentId = str3;
        this.pathType = str4;
        this.activityName = str5;
    }

    public static List<EventBinding> parseArray(JSONArray jSONArray) {
        int length;
        int i = 0;
        AppMethodBeat.i(72097);
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            try {
                length = jSONArray.length();
            } catch (JSONException e) {
            }
        } else {
            length = 0;
        }
        while (i < length) {
            arrayList.add(getInstanceFromJson(jSONArray.getJSONObject(i)));
            i++;
        }
        AppMethodBeat.o(72097);
        return arrayList;
    }

    public static EventBinding getInstanceFromJson(JSONObject jSONObject) {
        int i = 0;
        AppMethodBeat.i(72098);
        String string = jSONObject.getString("event_name");
        MappingMethod valueOf = MappingMethod.valueOf(jSONObject.getString(b.METHOD).toUpperCase());
        ActionType valueOf2 = ActionType.valueOf(jSONObject.getString("event_type").toUpperCase());
        String string2 = jSONObject.getString("app_version");
        JSONArray jSONArray = jSONObject.getJSONArray("path");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(new PathComponent(jSONArray.getJSONObject(i2)));
        }
        String optString = jSONObject.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE);
        JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray != null) {
            while (i < optJSONArray.length()) {
                arrayList2.add(new ParameterComponent(optJSONArray.getJSONObject(i)));
                i++;
            }
        }
        EventBinding eventBinding = new EventBinding(string, valueOf, valueOf2, string2, arrayList, arrayList2, jSONObject.optString("component_id"), optString, jSONObject.optString("activity_name"));
        AppMethodBeat.o(72098);
        return eventBinding;
    }

    public List<PathComponent> getViewPath() {
        AppMethodBeat.i(72099);
        List unmodifiableList = Collections.unmodifiableList(this.path);
        AppMethodBeat.o(72099);
        return unmodifiableList;
    }

    public List<ParameterComponent> getViewParameters() {
        AppMethodBeat.i(72100);
        List unmodifiableList = Collections.unmodifiableList(this.parameters);
        AppMethodBeat.o(72100);
        return unmodifiableList;
    }

    public String getEventName() {
        return this.eventName;
    }

    public ActionType getType() {
        return this.type;
    }

    public MappingMethod getMethod() {
        return this.method;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getComponentId() {
        return this.componentId;
    }

    public String getPathType() {
        return this.pathType;
    }

    public String getActivityName() {
        return this.activityName;
    }
}
