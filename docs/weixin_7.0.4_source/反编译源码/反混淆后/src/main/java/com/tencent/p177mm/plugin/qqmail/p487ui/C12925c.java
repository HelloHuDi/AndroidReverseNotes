package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C9399ki;
import com.tencent.p177mm.plugin.qqmail.p1618a.C43401a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.c */
public final class C12925c implements C1202f {
    private static long pzl = 0;
    private Activity czX;
    private C12927a pzm;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.c$2 */
    class C129262 implements C1835a {
        C129262() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(68412);
            if (c1902e == null) {
                AppMethodBeat.m2505o(68412);
                return;
            }
            c1902e.adg().mo5482a(new byte[0], new byte[0], new byte[0], c1902e.adg().mo5480QF());
            C43401a.gkF.mo38844BS();
            AppMethodBeat.m2505o(68412);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.c$a */
    public static abstract class C12927a {
        public abstract void ccF();

        public abstract void ccG();
    }

    public C12925c(Activity activity) {
        AppMethodBeat.m2504i(68413);
        C1720g.m3535RO().eJo.mo14539a(138, (C1202f) this);
        this.czX = activity;
        AppMethodBeat.m2505o(68413);
    }

    /* renamed from: a */
    public final void mo24951a(C12927a c12927a) {
        AppMethodBeat.m2504i(68414);
        this.pzm = c12927a;
        final C4883b c9399ki = new C9399ki();
        c9399ki.cFO.czX = this.czX;
        c9399ki.cFO.cFQ = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(68411);
                if (c9399ki.cFP.cvi) {
                    C12925c.m20911a(C12925c.this);
                    AppMethodBeat.m2505o(68411);
                    return;
                }
                if (C12925c.this.pzm != null) {
                    C12925c.this.pzm.ccG();
                }
                AppMethodBeat.m2505o(68411);
            }
        };
        C4879a.xxA.mo10048a(c9399ki, Looper.myLooper());
        AppMethodBeat.m2505o(68414);
    }

    public final void release() {
        AppMethodBeat.m2504i(68415);
        C1720g.m3535RO().eJo.mo14546b(138, (C1202f) this);
        AppMethodBeat.m2505o(68415);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(68416);
        release();
        super.finalize();
        AppMethodBeat.m2505o(68416);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(68417);
        if (i == 0 && i2 == 0) {
            if (this.pzm != null) {
                this.pzm.ccF();
                this.pzm = null;
            }
        } else if (this.pzm != null) {
            this.pzm.ccG();
            this.pzm = null;
        }
        pzl = System.currentTimeMillis();
        AppMethodBeat.m2505o(68417);
    }
}
