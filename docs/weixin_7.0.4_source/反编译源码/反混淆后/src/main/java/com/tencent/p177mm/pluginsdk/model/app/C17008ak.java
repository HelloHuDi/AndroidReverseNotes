package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ak */
public final class C17008ak implements C14875aj {
    public volatile boolean cEn;
    public volatile boolean ftW;
    public volatile boolean hxt;
    public volatile boolean hxu;
    C17009a vcJ;

    /* renamed from: com.tencent.mm.pluginsdk.model.app.ak$a */
    public interface C17009a {
        /* renamed from: r */
        void mo9615r(boolean z, boolean z2);
    }

    public C17008ak(C17009a c17009a) {
        this.vcJ = c17009a;
    }

    /* renamed from: dR */
    public final void mo6036dR(boolean z) {
        AppMethodBeat.m2504i(79395);
        this.ftW = true;
        this.hxt = z;
        if (this.hxu && this.vcJ != null) {
            this.vcJ.mo9615r(this.cEn, z);
        }
        AppMethodBeat.m2505o(79395);
    }

    /* renamed from: dS */
    public final void mo31082dS(boolean z) {
        AppMethodBeat.m2504i(79396);
        this.cEn = z;
        this.hxu = true;
        if (this.ftW && this.vcJ != null) {
            this.vcJ.mo9615r(z, this.hxt);
        }
        AppMethodBeat.m2505o(79396);
    }
}
