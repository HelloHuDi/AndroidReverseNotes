package com.tencent.p177mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11926g;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11927i;
import com.tencent.p177mm.plugin.fingerprint.p413b.C11928j;
import com.tencent.p177mm.plugin.fingerprint.p413b.C20756b;
import com.tencent.p177mm.plugin.fingerprint.p413b.C28048k;
import com.tencent.p177mm.plugin.fingerprint.p413b.C3117r;
import com.tencent.p177mm.plugin.fingerprint.p413b.C39086c;
import com.tencent.p177mm.plugin.fingerprint.p413b.C45944f;
import com.tencent.p177mm.plugin.fingerprint.p413b.C6911p;
import com.tencent.p177mm.plugin.fingerprint.p414ui.C43099a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.wallet_core.C24143a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.fingerprint.a */
public class C43094a implements C1816at {
    private C6911p mqI = new C6911p();
    private C11928j mqJ = new C11928j();
    private C28048k mqK = new C28048k();
    private C20756b mqL = new C20756b();
    private C45944f mqM = new C45944f();
    private C11926g mqN = new C11926g();
    private C39086c mqO;

    public C43094a() {
        AppMethodBeat.m2504i(41348);
        AppMethodBeat.m2505o(41348);
    }

    static {
        AppMethodBeat.m2504i(41353);
        C24143a.m37115g("FingerprintAuth", C43099a.class);
        AppMethodBeat.m2505o(41353);
    }

    public static C43094a bwM() {
        AppMethodBeat.m2504i(41349);
        C43094a c43094a = (C43094a) C7485q.m12925Y(C43094a.class);
        AppMethodBeat.m2505o(41349);
        return c43094a;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(41350);
        C4879a.xxA.mo10052c(this.mqI);
        C4879a.xxA.mo10052c(this.mqJ);
        C4879a.xxA.mo10052c(this.mqK);
        C4879a.xxA.mo10052c(this.mqL);
        C4879a.xxA.mo10052c(this.mqM);
        C4879a.xxA.mo10052c(this.mqN);
        C1720g.m3543a(C11927i.class, new C6625e(new C3117r()));
        AppMethodBeat.m2505o(41350);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(41351);
        C4879a.xxA.mo10053d(this.mqI);
        this.mqJ.release();
        C4879a.xxA.mo10053d(this.mqJ);
        C4879a.xxA.mo10053d(this.mqK);
        C4879a.xxA.mo10053d(this.mqL);
        C4879a.xxA.mo10053d(this.mqM);
        if (this.mqO != null) {
            C39086c.abort();
            C39086c.release();
            this.mqO = null;
        }
        C4879a.xxA.mo10053d(this.mqN);
        C1720g.m3529L(C11927i.class);
        AppMethodBeat.m2505o(41351);
    }

    public static C39086c bwN() {
        AppMethodBeat.m2504i(41352);
        C1720g.m3534RN().mo5159QU();
        if (C43094a.bwM().mqO == null) {
            C43094a.bwM().mqO = new C39086c();
        }
        C39086c c39086c = C43094a.bwM().mqO;
        AppMethodBeat.m2505o(41352);
        return c39086c;
    }
}
