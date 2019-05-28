package com.tencent.mm.plugin.story.g;

import a.f.b.j;
import a.k.u;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "", "()V", "traceJsonArray", "Lorg/json/JSONArray;", "addTrace", "", "aid", "", "checkLength", "", "trace", "Lorg/json/JSONObject;", "getTraceString", "", "plugin-story_release"})
public final class a {
    private JSONArray sbg = new JSONArray();

    public a() {
        AppMethodBeat.i(109763);
        AppMethodBeat.o(109763);
    }

    public final void EU(int i) {
        Object obj;
        AppMethodBeat.i(109761);
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
        AppMethodBeat.o(109761);
    }

    public final String czP() {
        AppMethodBeat.i(109762);
        String jSONArray = this.sbg.toString();
        j.o(jSONArray, "traceJsonArray.toString()");
        jSONArray = u.i(jSONArray, ",", ";", false);
        this.sbg = new JSONArray();
        AppMethodBeat.o(109762);
        return jSONArray;
    }
}
