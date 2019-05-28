package com.tencent.p177mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.C41231b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.coverview.h */
public final class C26961h extends C41231b {
    private static final int CTRL_INDEX = 255;
    public static final String NAME = "removeTextView";

    /* renamed from: r */
    public final int mo6130r(JSONObject jSONObject) {
        AppMethodBeat.m2504i(126312);
        int i = jSONObject.getInt("viewId");
        AppMethodBeat.m2505o(126312);
        return i;
    }

    /* renamed from: b */
    public final boolean mo22053b(C33303e c33303e, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126313);
        c33303e.aBf().mo73446pA(i);
        boolean b = super.mo22053b(c33303e, i, view, jSONObject);
        AppMethodBeat.m2505o(126313);
        return b;
    }
}
