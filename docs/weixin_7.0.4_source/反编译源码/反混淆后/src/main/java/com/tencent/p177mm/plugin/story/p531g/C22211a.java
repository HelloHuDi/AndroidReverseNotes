package com.tencent.p177mm.plugin.story.p531g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "", "()V", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.g.a */
public final class C22211a {
    private JSONArray sbg = new JSONArray();

    public C22211a() {
        AppMethodBeat.m2504i(109763);
        AppMethodBeat.m2505o(109763);
    }

    /* renamed from: EU */
    public final void mo37760EU(int i) {
        Object obj;
        AppMethodBeat.m2504i(109761);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", i);
        jSONObject.put("td", this.sbg.length() + 1);
        if (this.sbg.toString().length() + jSONObject.toString().length() > 1000) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.sbg.put(jSONObject);
        }
        AppMethodBeat.m2505o(109761);
    }

    public final String czP() {
        AppMethodBeat.m2504i(109762);
        String jSONArray = this.sbg.toString();
        C25052j.m39375o(jSONArray, "traceJsonArray.toString()");
        jSONArray = C6163u.m9838i(jSONArray, ",", ";", false);
        this.sbg = new JSONArray();
        AppMethodBeat.m2505o(109762);
        return jSONArray;
    }
}
