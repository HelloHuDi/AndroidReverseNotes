package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C41231b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.i */
public final class C42477i extends C41231b<C33303e> {
    public static final int CTRL_INDEX = 68;
    public static final String NAME = "removeCanvas";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(103856);
        int optInt = jSONObject.optInt("canvasId");
        AppMethodBeat.m2505o(103856);
        return optInt;
    }
}
