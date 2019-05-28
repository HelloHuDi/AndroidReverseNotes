package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i */
public final class C26813i extends C2099b {
    public static final C26813i hdG = new C26813i();

    static {
        AppMethodBeat.m2504i(103649);
        AppMethodBeat.m2505o(103649);
    }

    public static C26813i ayp() {
        return hdG;
    }

    /* renamed from: a */
    public final void mo5900a(C10148a c10148a) {
        AppMethodBeat.m2504i(103647);
        c10148a.reset();
        c10148a.release();
        c10148a.setStyle(Style.STROKE);
        c10148a.setAntiAlias(true);
        c10148a.setStrokeWidth((float) C42668g.m75571qb(1));
        super.mo5900a(c10148a);
        AppMethodBeat.m2505o(103647);
    }

    public final C10148a ayi() {
        AppMethodBeat.m2504i(103648);
        C10148a c10148a = new C10148a();
        c10148a.setStyle(Style.STROKE);
        c10148a.setAntiAlias(true);
        c10148a.setStrokeWidth((float) C42668g.m75571qb(1));
        AppMethodBeat.m2505o(103648);
        return c10148a;
    }
}
