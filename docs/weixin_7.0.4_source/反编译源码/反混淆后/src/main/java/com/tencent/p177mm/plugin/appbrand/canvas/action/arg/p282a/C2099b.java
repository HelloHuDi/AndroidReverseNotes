package com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a;

import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.sdk.platformtools.C35993bg;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.arg.a.b */
public abstract class C2099b {
    private C35993bg<C10148a> hdw = new C35993bg(100);

    public abstract C10148a ayi();

    public final C10148a ayh() {
        C10148a c10148a = (C10148a) this.hdw.mo56734aA();
        if (c10148a == null) {
            return ayi();
        }
        return c10148a;
    }

    /* renamed from: a */
    public void mo5900a(C10148a c10148a) {
        if (c10148a != null) {
            this.hdw.release(c10148a);
        }
    }
}
