package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.tencent.mm.z.b.c {
    public String data;

    public c() {
        super("onDataPush");
    }

    c(int i) {
        super("onDataPush", i);
    }

    public final JSONObject toJSONObject() {
        AppMethodBeat.i(10912);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", bo.nullAsNil(this.data));
        } catch (JSONException e) {
        }
        AppMethodBeat.o(10912);
        return jSONObject;
    }
}
