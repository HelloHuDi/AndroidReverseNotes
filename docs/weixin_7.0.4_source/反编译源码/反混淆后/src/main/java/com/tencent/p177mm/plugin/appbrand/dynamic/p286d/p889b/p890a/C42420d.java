package com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.p890a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b.a.d */
public final class C42420d extends C10202a {
    /* renamed from: d */
    public final /* synthetic */ Object mo21618d(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(10899);
        DrawCanvasArg c = mo21617c(jSONObject, str);
        AppMethodBeat.m2505o(10899);
        return c;
    }

    /* renamed from: c */
    public final DrawCanvasArg mo21617c(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(10898);
        DrawCanvasArg c = super.mo21618d(jSONObject, str);
        c.mo60892h(jSONObject.optJSONArray("actions"));
        AppMethodBeat.m2505o(10898);
        return c;
    }

    public final int azV() {
        return 0;
    }
}
