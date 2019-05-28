package com.tencent.p177mm.plugin.appbrand.dynamic.p1220f;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C46727c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.f.b */
public final class C19183b extends C46727c {
    public String cacheKey;
    public Map<String, String> hod;
    public int hoe;
    public int hof;
    public String path;
    public String title;

    public C19183b() {
        super("onCanvasInsert");
    }

    C19183b(int i) {
        super("onCanvasInsert", i);
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.m2504i(10911);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.title);
            jSONObject.put("path", this.path);
            jSONObject.put(SearchIntents.EXTRA_QUERY, new JSONObject(this.hod == null ? new HashMap() : this.hod));
            jSONObject.put("cacheKey", this.cacheKey);
            jSONObject.put("width", C42668g.m75570qa(this.hoe));
            jSONObject.put("height", C42668g.m75570qa(this.hof));
        } catch (JSONException e) {
        }
        AppMethodBeat.m2505o(10911);
        return jSONObject;
    }
}
