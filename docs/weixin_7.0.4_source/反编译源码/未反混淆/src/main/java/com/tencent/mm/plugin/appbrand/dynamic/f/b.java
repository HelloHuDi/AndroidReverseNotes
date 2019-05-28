package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.z.b.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c {
    public String cacheKey;
    public Map<String, String> hod;
    public int hoe;
    public int hof;
    public String path;
    public String title;

    public b() {
        super("onCanvasInsert");
    }

    b(int i) {
        super("onCanvasInsert", i);
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.i(10911);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.title);
            jSONObject.put("path", this.path);
            jSONObject.put(SearchIntents.EXTRA_QUERY, new JSONObject(this.hod == null ? new HashMap() : this.hod));
            jSONObject.put("cacheKey", this.cacheKey);
            jSONObject.put("width", g.qa(this.hoe));
            jSONObject.put("height", g.qa(this.hof));
        } catch (JSONException e) {
        }
        AppMethodBeat.o(10911);
        return jSONObject;
    }
}
