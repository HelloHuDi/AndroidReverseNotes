package com.tencent.p177mm.plugin.appbrand.dynamic.p1220f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C46727c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.f.c */
public final class C19184c extends C46727c {
    public String data;

    public C19184c() {
        super("onDataPush");
    }

    C19184c(int i) {
        super("onDataPush", i);
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.m2504i(10912);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", C5046bo.nullAsNil(this.data));
        } catch (JSONException e) {
        }
        AppMethodBeat.m2505o(10912);
        return jSONObject;
    }
}
