package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p189aq.C32267c;
import com.tencent.p177mm.p189aq.C6320b;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6981n;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.modelmulti.n */
public class C18668n implements C1816at {
    public static HashMap<Integer, C1366d> eaA = new HashMap();
    private C32267c fJe;

    static {
        AppMethodBeat.m2504i(16510);
        AppMethodBeat.m2505o(16510);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(16505);
        C4879a c4879a = C4879a.xxA;
        C32267c c32267c = new C32267c();
        this.fJe = c32267c;
        c4879a.mo10052c(c32267c);
        AppMethodBeat.m2505o(16505);
    }

    public static C6981n ahV() {
        AppMethodBeat.m2504i(16506);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C6981n ahV = ((C6982j) C1720g.m3528K(C6982j.class)).ahV();
        AppMethodBeat.m2505o(16506);
        return ahV;
    }

    public static C26460o ahW() {
        AppMethodBeat.m2504i(16507);
        C26460o ahW = ((C35779b) C1720g.m3528K(C35779b.class)).ahW();
        AppMethodBeat.m2505o(16507);
        return ahW;
    }

    public static C18668n ahX() {
        AppMethodBeat.m2504i(16508);
        C9638aw.m17184ZE();
        C18668n c18668n = (C18668n) C45439bw.m83697oJ(C18668n.class.getName());
        if (c18668n == null) {
            c18668n = new C18668n();
            C9638aw.m17184ZE().mo73244a(C18668n.class.getName(), c18668n);
        }
        AppMethodBeat.m2505o(16508);
        return c18668n;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(16509);
        if (this.fJe != null) {
            C32267c c32267c = this.fJe;
            C4879a.xxA.mo10053d(c32267c.fCr);
            C6320b.agG().fCk = null;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10121b(c32267c);
            C18668n.ahX();
            C18668n.ahV().mo10117d(c32267c);
            C4879a.xxA.mo10053d(this.fJe);
        }
        AppMethodBeat.m2505o(16509);
    }
}
