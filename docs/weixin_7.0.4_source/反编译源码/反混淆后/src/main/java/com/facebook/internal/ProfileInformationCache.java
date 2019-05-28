package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class ProfileInformationCache {
    private static final ConcurrentHashMap<String, JSONObject> infoCache = new ConcurrentHashMap();

    ProfileInformationCache() {
    }

    static {
        AppMethodBeat.m2504i(72475);
        AppMethodBeat.m2505o(72475);
    }

    public static JSONObject getProfileInformation(String str) {
        AppMethodBeat.m2504i(72473);
        JSONObject jSONObject = (JSONObject) infoCache.get(str);
        AppMethodBeat.m2505o(72473);
        return jSONObject;
    }

    public static void putProfileInformation(String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(72474);
        infoCache.put(str, jSONObject);
        AppMethodBeat.m2505o(72474);
    }
}
