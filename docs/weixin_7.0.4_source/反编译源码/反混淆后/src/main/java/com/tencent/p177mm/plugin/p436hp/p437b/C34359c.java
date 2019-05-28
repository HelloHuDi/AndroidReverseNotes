package com.tencent.p177mm.plugin.p436hp.p437b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p230g.p231a.C42010ip;
import com.tencent.p177mm.plugin.p436hp.p1273d.C21070a;
import com.tencent.p177mm.plugin.p436hp.tinker.C34364d;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.p604g.p605a.C4942d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.hp.b.c */
public final class C34359c extends C4884c<C42010ip> implements C4942d {
    private static final String eSG = (C6457e.eSj + "_temp.hp");
    private C21070a ntB;

    static {
        AppMethodBeat.m2504i(90583);
        AppMethodBeat.m2505o(90583);
    }

    public C34359c() {
        AppMethodBeat.m2504i(90578);
        this.ntB = null;
        this.xxI = C42010ip.class.getName().hashCode();
        AppMethodBeat.m2505o(90578);
    }

    /* renamed from: OF */
    public static void m56333OF(String str) {
        AppMethodBeat.m2504i(90579);
        C4990ab.m7421w("Tinker.HotPatchApplyService", "hp_apply from file %s", str);
        C34364d.m56346OG(str);
        AppMethodBeat.m2505o(90579);
    }

    /* renamed from: a */
    public final void mo10145a(Runnable runnable, int i) {
    }

    /* renamed from: b */
    public final void mo10146b(Runnable runnable, int i) {
        AppMethodBeat.m2504i(90580);
        if (runnable == this.ntB) {
            C4990ab.m7411d("Tinker.HotPatchApplyService", "hp_apply download url=%s, file=%s, failed=%b", this.ntB.url, this.ntB.ghD, Boolean.valueOf(this.ntB.aAR));
            if (this.ntB.aAR) {
                C46028b.m85605wY(1);
            } else {
                C46028b.m85604wX(1);
                C34359c.m56333OF(this.ntB.ghD);
            }
            this.ntB = null;
        }
        AppMethodBeat.m2505o(90580);
    }

    /* renamed from: a */
    private boolean m56334a(C42010ip c42010ip) {
        AppMethodBeat.m2504i(90581);
        if (this.ntB != null) {
            C4990ab.m7412e("Tinker.HotPatchApplyService", "hp_apply processing busy, ignore new event");
            AppMethodBeat.m2505o(90581);
        } else if (1 == c42010ip.cDI.cuy) {
            C34364d.bGr();
            AppMethodBeat.m2505o(90581);
        } else if (c42010ip.cDI.cDN != null) {
            C34359c.m56333OF(c42010ip.cDI.cDN);
            AppMethodBeat.m2505o(90581);
        } else {
            C46028b.m85603wW(1);
            if (c42010ip.cDI.cDL != null) {
                try {
                    byte[] decode = Base64.decode(c42010ip.cDI.cDL, 0);
                    c42010ip.cDI.cDL = new String(decode);
                } catch (Error e) {
                }
            }
            if (!C5046bo.isNullOrNil(c42010ip.cDI.cDL) && !C5046bo.isNullOrNil(c42010ip.cDI.cDM)) {
                C4990ab.m7417i("Tinker.HotPatchApplyService", "hp_apply request url=%s, signature=%s", c42010ip.cDI.cDL, c42010ip.cDI.cDM);
                this.ntB = new C21070a(c42010ip.cDI.cDL, eSG, c42010ip.cDI.cDM);
            } else if (C5046bo.isNullOrNil(c42010ip.cDI.cDJ) || C5046bo.isNullOrNil(c42010ip.cDI.cDK)) {
                AppMethodBeat.m2505o(90581);
            }
            C7305d.xDG.mo10147a(this.ntB, "hp_apply_download", this);
            AppMethodBeat.m2505o(90581);
        }
        return false;
    }
}
