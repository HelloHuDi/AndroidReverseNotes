package com.tencent.p177mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.platformtools.c */
public final class C45476c {
    private C1950n ggR;
    private C1951o ggS;
    private C16543p ggT;
    private C26527l ggU;
    private C1949m ggV;
    private C37986k ggW;

    /* renamed from: a */
    public final boolean mo73273a(Activity activity, C45475ag c45475ag) {
        AppMethodBeat.m2504i(124515);
        if (c45475ag.type == 0 || c45475ag.action == 0) {
            AppMethodBeat.m2505o(124515);
            return false;
        }
        if (this.ggW == null) {
            this.ggW = new C37986k(activity);
        }
        if (this.ggW.mo21143a(c45475ag)) {
            AppMethodBeat.m2505o(124515);
            return true;
        }
        switch (c45475ag.type) {
            case 1:
                if (this.ggR == null) {
                    this.ggR = new C1950n(activity);
                }
                this.ggR.mo21143a(c45475ag);
                break;
            case 2:
                if (this.ggS == null) {
                    this.ggS = new C1951o(activity);
                }
                this.ggS.mo21143a(c45475ag);
                break;
            case 3:
                if (this.ggT == null) {
                    this.ggT = new C16543p(activity);
                }
                this.ggT.mo21143a(c45475ag);
                break;
            case 4:
                if (this.ggU == null) {
                    this.ggU = new C26527l(activity);
                }
                this.ggU.mo21143a(c45475ag);
                break;
            case 5:
                if (this.ggV == null) {
                    this.ggV = new C1949m(activity);
                }
                this.ggV.mo21143a(c45475ag);
                break;
            case 6:
                if (this.ggW == null) {
                    this.ggW = new C37986k(activity);
                }
                this.ggW.mo21143a(c45475ag);
                break;
            default:
                C4990ab.m7412e("MicroMsg.BaseErrorHelper", "Unkown error type");
                break;
        }
        AppMethodBeat.m2505o(124515);
        return false;
    }

    /* renamed from: a */
    private static void m83803a(C9788d c9788d) {
        AppMethodBeat.m2504i(124516);
        if (c9788d != null) {
            for (Integer intValue : c9788d.ggX) {
                C1720g.m3540Rg().mo14546b(intValue.intValue(), (C1202f) c9788d);
            }
            c9788d.activity = null;
        }
        AppMethodBeat.m2505o(124516);
    }

    public final void close() {
        AppMethodBeat.m2504i(124517);
        C45476c.m83803a(this.ggR);
        C45476c.m83803a(this.ggS);
        C45476c.m83803a(this.ggT);
        C45476c.m83803a(this.ggU);
        C45476c.m83803a(this.ggV);
        C45476c.m83803a(this.ggW);
        AppMethodBeat.m2505o(124517);
    }
}
