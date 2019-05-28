package com.tencent.p177mm.plugin.appbrand.p332t;

import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C33533d.C33534a;
import com.tencent.p177mm.plugin.appbrand.p332t.p1232d.C41253e;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C33535i;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C42689e;

/* renamed from: com.tencent.mm.plugin.appbrand.t.b */
public abstract class C33530b implements C27303d {
    protected boolean iSt;

    public final C33535i aOh() {
        return new C42689e();
    }

    /* renamed from: b */
    public void mo34733b(C38514a c38514a) {
    }

    /* renamed from: c */
    public void mo44998c(C33533d c33533d) {
    }

    /* renamed from: a */
    public final void mo44995a(C33526a c33526a, C33533d c33533d) {
        C41253e c41253e = new C41253e(c33533d);
        c41253e.mo61234a(C33534a.PONG);
        c33526a.mo54002b(c41253e);
    }

    public final void setTcpNoDelay(boolean z) {
        this.iSt = z;
    }
}
