package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C45578c;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.k */
public final class C42479k extends C45578c {
    public static final int CTRL_INDEX = 83;
    public static final String NAME = "updateCanvas";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103857);
        int optInt = jSONObject.optInt("canvasId");
        AppMethodBeat.m2505o(103857);
        return optInt;
    }

    public final boolean aCF() {
        return true;
    }
}
