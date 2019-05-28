package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C42680k;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C11017h;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C2572f;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.j */
public final class C17105j extends C17091i {
    private static final int CTRL_INDEX = 111;
    private static final String NAME = "updateTextArea";

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ boolean mo30637a(C2572f c2572f, JSONObject jSONObject, C44709u c44709u, int i) {
        Boolean bool;
        AppMethodBeat.m2504i(123565);
        C11017h c11017h = (C11017h) c2572f;
        boolean a = super.mo30637a(c11017h, jSONObject, c44709u, i);
        c11017h.jjF = Boolean.TRUE;
        c11017h.jjL = Boolean.FALSE;
        Object opt = jSONObject.opt("confirm");
        if (opt == null) {
            bool = null;
        } else {
            bool = C42680k.m75587bG(opt);
        }
        c11017h.jjG = bool;
        AppMethodBeat.m2505o(123565);
        return a;
    }

    /* renamed from: a */
    public final void mo31165a(C44709u c44709u, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(123564);
        super.mo31165a(c44709u, jSONObject, i);
        AppMethodBeat.m2505o(123564);
    }
}
