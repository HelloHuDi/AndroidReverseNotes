package com.tencent.p177mm.plugin.appbrand.jsapi.container;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C41231b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.container.b */
public final class C10368b extends C41231b {
    public static final int CTRL_INDEX = 512;
    public static final String NAME = "removePositioningContainer";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126280);
        int i = jSONObject.getInt("containerId");
        AppMethodBeat.m2505o(126280);
        return i;
    }
}
