package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a;

import android.graphics.Paint.Style;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e */
public final class C33121e extends C2099b {
    private static C33121e hdC = new C33121e();

    static {
        AppMethodBeat.m2504i(103640);
        AppMethodBeat.m2505o(103640);
    }

    private C33121e() {
    }

    public static C33121e ayl() {
        return hdC;
    }

    /* renamed from: a */
    public final void mo5900a(C10148a c10148a) {
        AppMethodBeat.m2504i(103638);
        c10148a.reset();
        c10148a.release();
        c10148a.setStyle(Style.FILL);
        c10148a.setAntiAlias(true);
        c10148a.setStrokeWidth((float) C42668g.m75571qb(1));
        super.mo5900a(c10148a);
        AppMethodBeat.m2505o(103638);
    }

    public final C10148a ayi() {
        AppMethodBeat.m2504i(103639);
        C10148a c10148a = new C10148a();
        c10148a.setStyle(Style.FILL);
        c10148a.setAntiAlias(true);
        c10148a.setStrokeWidth((float) C42668g.m75571qb(1));
        AppMethodBeat.m2505o(103639);
        return c10148a;
    }
}
